package com.kravchenko.events.dto.response;

public record UserResponse(
        String id,
        String name,
        String surname,
        String email
) {
}
