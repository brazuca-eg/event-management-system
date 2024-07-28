package com.kravchenko.events.event_ms.service;

import com.kravchenko.events.event_ms.dto.request.CreateEventRequest;
import com.kravchenko.events.event_ms.dto.request.EventFilter;
import com.kravchenko.events.event_ms.dto.response.EventResponse;

import java.util.List;

public interface EventService {

    String createEvent(CreateEventRequest eventRequest);

    List<EventResponse> findEvents(EventFilter eventFilter);

    EventResponse findById(String id);
}
