package com.kravchenko.events.event_ms.converter;

import com.kravchenko.events.event_ms.dto.request.CreateEventRequest;
import com.kravchenko.events.event_ms.entity.Event;
import org.springframework.core.convert.converter.Converter;

public class CreateEventRequestToEventConverter implements Converter<CreateEventRequest, Event> {

    @Override
    public Event convert(CreateEventRequest createEventRequest) {
        Event event = new Event();
        event.setName(createEventRequest.name());
        event.setDescription(createEventRequest.description());
        event.setDuration(createEventRequest.duration());
        event.setPlaces(createEventRequest.places());
        event.setHostId(createEventRequest.hostId());
        event.setStartDate(createEventRequest.startDate());
        event.setPrice(createEventRequest.price());
        event.setPlatform(createEventRequest.platform());
        event.setLinkToEvent(createEventRequest.linkToEvent());
        return event;
    }
}
