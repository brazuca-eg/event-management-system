package com.kravchenko.events.event_ms.dto.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EventFilter {

    private String hostId;
    private LocalDateTime startDateFrom;
    private LocalDateTime startDateTo;
    private String platform;
    private boolean isAvailablePlaces;
    @Positive(message = "Minimum duration should be positive")
    private Integer minDuration;
    @Positive(message = "Maximum duration should be positive")
    private Integer maxDuration;
    @Positive(message = "Minimum price should be positive")
    private BigDecimal minPrice;
    @Positive(message = "Maximum price should be positive")
    private BigDecimal maxPrice;

    @AssertTrue(message = "Start date must be before end date")
    public boolean isDateRangeValid() {
        if (startDateFrom != null && startDateTo != null) {
            return startDateFrom.equals(startDateTo) || startDateFrom.isBefore(startDateTo);
        }
        return true;
    }

    @AssertTrue(message = "Minimum duration must be less than maximum duration")
    public boolean isDurationRangeValid() {
        return isRangeValid(minDuration, maxDuration);
    }

    @AssertTrue(message = "Minimum price must be less than maximum price")
    public boolean isPriceRangeValid() {
        return isRangeValid(minPrice, maxPrice);
    }

    private <T extends Comparable<T>> boolean isRangeValid(T minValue, T maxValue) {
        if (minValue != null && maxValue != null) {
            return minValue.compareTo(maxValue) <= 0;
        }
        return true;
    }
}
