package com.kravchenko.events.users_ms.dto.response;

public record UserResponse(
        String id,
        String name,
        String surname,
        String email
) {
}
