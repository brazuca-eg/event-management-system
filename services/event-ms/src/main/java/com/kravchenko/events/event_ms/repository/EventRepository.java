package com.kravchenko.events.event_ms.repository;

import com.kravchenko.events.event_ms.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
}
