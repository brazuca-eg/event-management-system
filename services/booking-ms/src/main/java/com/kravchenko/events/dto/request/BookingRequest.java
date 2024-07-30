package com.kravchenko.events.dto.request;

public record BookingRequest(
        String hostId,
        String eventId,
        String attendeeId
) {
}