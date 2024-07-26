package com.kravchenko.events.users_ms.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequest(

        @NotBlank(message = "Email is required")
        @NotEmpty(message = "Email is required")
        @Email(message = "Email should be in appropriate pattern")
        String email,
        @NotBlank(message = "Name is required")
        @NotEmpty(message = "Name is required")
        String name,
        @NotBlank(message = "Surname is required")
        @NotEmpty(message = "Surname is required")
        String surname
) {
}
