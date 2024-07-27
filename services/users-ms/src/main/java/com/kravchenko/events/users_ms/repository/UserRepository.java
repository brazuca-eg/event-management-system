package com.kravchenko.events.users_ms.repository;

import com.kravchenko.events.users_ms.entity.ServiceUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<ServiceUser, String> {

    @Query("select (count(s) > 0) from ServiceUser s where upper(s.email) = upper(?1)")
    boolean existsByEmailIgnoreCase(String email);
}
