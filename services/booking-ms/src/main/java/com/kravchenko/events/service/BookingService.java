package com.kravchenko.events.service;

import com.kravchenko.events.dto.request.BookingRequest;

public interface BookingService {

    String createBooking(BookingRequest bookingRequest);
}
