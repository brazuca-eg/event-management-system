package com.kravchenko.events.service;

import com.kravchenko.events.dto.request.BookingRequest;
import com.kravchenko.events.entity.Notification;
import com.kravchenko.events.repository.NotificationRepository;
import jakarta.mail.MessagingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationConsumer {

    private final NotificationRepository repository;

    public NotificationConsumer(NotificationRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "booking-topic")
    public void consumeOrderConfirmationNotifications(BookingRequest bookingRequest) throws MessagingException {
        repository.save(
                Notification.builder()
                        .createdDate(LocalDateTime.now())
                        .bookingRequest(bookingRequest)
                        .build()
        );

        //toDo: send email
    }
}
