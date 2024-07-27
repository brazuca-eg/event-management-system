package com.kravchenko.events.event_ms.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateEventRequest(

        @NotNull(message = "Host of the event is required")
        @NotBlank(message = "Host of the event is required")
        @NotEmpty(message = "Host of the event is required")
        String hostId,
        @NotNull(message = "Event's name is required")
        String name,
        @NotNull(message = "Event's description is required")
        String description,
        @NotNull(message = "Event's start date is required")
        @Future
        LocalDateTime startDate,
        @NotNull(message = "Event's duration is required")
        @Positive(message = "Duration should be positive")
        int duration,
        @NotNull(message = "Event's places is required")
        @Positive(message = "Event's places should be positive")
        int places,
        @Positive(message = "Event's price should be positive")
        BigDecimal price,
        @NotNull(message = "Event's platform is required")
        String platform,
        @NotNull(message = "Event's link is required")
        String linkToEvent
) {
}