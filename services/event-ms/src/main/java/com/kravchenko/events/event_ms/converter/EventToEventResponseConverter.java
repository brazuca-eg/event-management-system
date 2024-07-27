package com.kravchenko.events.event_ms.converter;

import com.kravchenko.events.event_ms.dto.response.EventResponse;
import com.kravchenko.events.event_ms.entity.Event;
import org.springframework.core.convert.converter.Converter;

public class EventToEventResponseConverter implements Converter<Event, EventResponse> {

    @Override
    public EventResponse convert(Event event) {
        return new EventResponse(event.getId(), event.getHostId(), event.getName(), event.getDescription(),
                event.getStartDate(), event.getDuration(), event.getPlaces(), event.getPrice(), event.getPlatform(),
                event.getLinkToEvent());
    }
}
