package com.kravchenko.events.booking_ms.dto.response.user;

public record UserResponse(
        String id,
        String name,
        String surname,
        String email
) {
}
