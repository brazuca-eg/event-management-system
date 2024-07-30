package com.kravchenko.events.dto.response.user;

public record UserResponse(
        String id,
        String name,
        String surname,
        String email
) {
}
