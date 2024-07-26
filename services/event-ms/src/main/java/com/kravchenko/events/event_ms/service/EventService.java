package com.kravchenko.events.event_ms.service;

import com.kravchenko.events.event_ms.dto.request.CreateEventRequest;

public interface EventService {

    String createEvent(CreateEventRequest eventRequest);
}
