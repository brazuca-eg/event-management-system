package com.kravchenko.events.event_ms.repository;

import com.kravchenko.events.event_ms.entity.Event;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {

    @Query(value = "SELECT * FROM events e WHERE " +
            "(:hostId IS NULL OR e.host_id = :hostId) AND " +
            "(:startDateFrom IS NULL OR e.start_date >= CAST(:startDateFrom AS TIMESTAMP)) AND " +
            "(:startDateTo IS NULL OR e.start_date <= CAST(:startDateTo AS TIMESTAMP)) AND " +
            "(:platform IS NULL OR e.platform = :platform) AND " +
            "(:isAvailablePlaces IS NULL OR e.places > 0) AND " +
            "(:minDuration IS NULL OR e.duration >= :minDuration) AND " +
            "(:maxDuration IS NULL OR e.duration <= :maxDuration) AND " +
            "(:minPrice IS NULL OR e.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR e.price <= :maxPrice)",
            nativeQuery = true)
    List<Event> findByFilter(
            @Param("hostId") String hostId,
            @Param("startDateFrom") String startDateFrom,
            @Param("startDateTo") String startDateTo,
            @Param("platform") String platform,
            @Param("isAvailablePlaces") Boolean isAvailablePlaces,
            @Param("minDuration") Integer minDuration,
            @Param("maxDuration") Integer maxDuration,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice);
}
