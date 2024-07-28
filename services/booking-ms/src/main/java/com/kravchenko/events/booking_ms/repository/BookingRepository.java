package com.kravchenko.events.booking_ms.repository;

import com.kravchenko.events.booking_ms.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, String> {
}
