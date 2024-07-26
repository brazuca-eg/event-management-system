package com.kravchenko.events.event_ms.controller;

import com.kravchenko.events.event_ms.dto.request.CreateEventRequest;
import com.kravchenko.events.event_ms.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<String> createEvent(@RequestBody @Valid CreateEventRequest eventRequest) {
        return ResponseEntity.ok(eventService.createEvent(eventRequest));
    }
}
