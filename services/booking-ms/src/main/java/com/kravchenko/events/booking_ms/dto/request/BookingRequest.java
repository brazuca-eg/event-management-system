package com.kravchenko.events.booking_ms.dto.request;

public record BookingRequest(
        String hostId,
        String eventId,
        String attendeeId
) {
}