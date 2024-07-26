package com.kravchenko.events.event_ms.dto.response;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}