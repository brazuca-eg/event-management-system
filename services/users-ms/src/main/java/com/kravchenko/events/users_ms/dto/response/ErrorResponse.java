package com.kravchenko.events.users_ms.dto.response;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}