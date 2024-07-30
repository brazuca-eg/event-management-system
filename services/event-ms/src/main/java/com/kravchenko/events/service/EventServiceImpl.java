package com.kravchenko.events.service;

import com.kravchenko.events.client.UsersClient;
import com.kravchenko.events.dto.request.CreateEventRequest;
import com.kravchenko.events.dto.request.EventFilter;
import com.kravchenko.events.dto.response.EventResponse;
import com.kravchenko.events.dto.response.UserResponse;
import com.kravchenko.events.entity.Event;
import com.kravchenko.events.exception.BusinessException;
import com.kravchenko.events.exception.EventNotFoundException;
import com.kravchenko.events.repository.EventRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ConversionService conversionService;
    private final UsersClient usersClient;

    public EventServiceImpl(EventRepository eventRepository, ConversionService conversionService, UsersClient usersClient) {
        this.eventRepository = eventRepository;
        this.conversionService = conversionService;
        this.usersClient = usersClient;
    }

    @Override
    public String createEvent(CreateEventRequest eventRequest) {
        UserResponse host = usersClient.findUserById(eventRequest.hostId())
                .orElseThrow(() -> new BusinessException("Can't create event. No host user with the provided id."));

        Event createdEvent = eventRepository.save(conversionService.convert(eventRequest, Event.class));

        return createdEvent.getId();
    }

    @Override
    public List<EventResponse> findEvents(EventFilter eventFilter) {
        List<Event> events = eventRepository.findByFilter(
                eventFilter.getHostId(),
                eventFilter.getStartDateFrom() != null ? eventFilter.getStartDateFrom().toString() : null,
                eventFilter.getStartDateTo() != null ? eventFilter.getStartDateTo().toString() : null,
                eventFilter.getPlatform(),
                eventFilter.isAvailablePlaces(),
                eventFilter.getMinDuration(),
                eventFilter.getMaxDuration(),
                eventFilter.getMinPrice(),
                eventFilter.getMaxPrice()
        );
        return events.stream()
                .map(event -> conversionService.convert(event, EventResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventResponse findById(String id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("There is no event with the provided id."));

        return conversionService.convert(event, EventResponse.class);
    }
}