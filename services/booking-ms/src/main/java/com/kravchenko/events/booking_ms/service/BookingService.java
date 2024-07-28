package com.kravchenko.events.booking_ms.service;

import com.kravchenko.events.booking_ms.dto.request.BookingRequest;

public interface BookingService {

    String createBooking(BookingRequest bookingRequest);
}
