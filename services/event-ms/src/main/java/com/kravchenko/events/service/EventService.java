package com.kravchenko.events.service;

import com.kravchenko.events.dto.request.CreateEventRequest;
import com.kravchenko.events.dto.request.EventFilter;
import com.kravchenko.events.dto.response.EventResponse;

import java.util.List;

public interface EventService {

    String createEvent(CreateEventRequest eventRequest);

    List<EventResponse> findEvents(EventFilter eventFilter);

    EventResponse findById(String id);
}
