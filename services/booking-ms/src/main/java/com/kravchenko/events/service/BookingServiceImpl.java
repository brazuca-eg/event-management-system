package com.kravchenko.events.service;

import com.kravchenko.events.client.EventClient;
import com.kravchenko.events.client.UserClient;
import com.kravchenko.events.dto.request.BookingRequest;
import com.kravchenko.events.dto.response.event.EventResponse;
import com.kravchenko.events.dto.response.user.UserResponse;
import com.kravchenko.events.entity.Booking;
import com.kravchenko.events.repository.BookingRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final EventClient eventClient;
    private final KafkaBookingProducer bookingProducer;

    public BookingServiceImpl(BookingRepository bookingRepository, UserClient userClient, EventClient eventClient, KafkaBookingProducer bookingProducer) {
        this.bookingRepository = bookingRepository;
        this.userClient = userClient;
        this.eventClient = eventClient;
        this.bookingProducer = bookingProducer;
    }

    @Transactional
    @Override
    public String createBooking(BookingRequest bookingRequest) {
        UserResponse hostUser = userClient.findUserById(bookingRequest.hostId())
                .orElseThrow(() -> new NotFoundException("Can't create booking:: No hosts with the provided ID"));

        UserResponse attendeeUser = userClient.findUserById(bookingRequest.attendeeId())
                .orElseThrow(() -> new NotFoundException("Can't create booking:: No attendees with the provided ID"));

        EventResponse eventResponse = eventClient.findById(bookingRequest.eventId())
                .orElseThrow(() -> new NotFoundException("Can't create booking:: No events with the provided ID"));

        Booking booking = Booking.builder()
                .eventId(bookingRequest.eventId())
                .hostId(bookingRequest.hostId())
                .attendeeId(bookingRequest.attendeeId())
                .build();

        Booking saved =  bookingRepository.save(booking);

        bookingProducer.sendBookingConfirmation(bookingRequest);
        return saved.getId();
    }
}
