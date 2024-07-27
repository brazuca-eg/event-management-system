package com.kravchenko.events.event_ms.dto.response;

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
