package com.kravchenko.events.controller;

import com.kravchenko.events.dto.request.CreateEventRequest;
import com.kravchenko.events.dto.request.EventFilter;
import com.kravchenko.events.dto.response.EventResponse;
import com.kravchenko.events.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<EventResponse>> findEvents(@ModelAttribute @Valid EventFilter eventFilter) {
        List<EventResponse> events = eventService.findEvents(eventFilter);
        if (events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(eventService.findById(id));
    }
}