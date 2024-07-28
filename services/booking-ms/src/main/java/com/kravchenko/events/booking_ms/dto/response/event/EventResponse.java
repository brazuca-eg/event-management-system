package com.kravchenko.events.booking_ms.dto.response.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventResponse(
        String id,

        String hostId,

        String name,

        String description,

        LocalDateTime startDate,

        int duration,

        int places,

        BigDecimal price,

        String platform,

        String linkToEvent
) {
}
