package com.kravchenko.events.client;

import com.kravchenko.events.dto.response.event.EventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "events-ms",
        url = "${application.config.events-url}"
)
public interface EventClient {

    @GetMapping("/{eventId}")
    Optional<EventResponse> findById(@PathVariable("eventId") String eventId);
}