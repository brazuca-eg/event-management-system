package com.kravchenko.events.client;

import com.kravchenko.events.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "users-ms",
        url = "${application.config.users-url}"
)
public interface UsersClient {

    @GetMapping("/{userId}")
    Optional<UserResponse> findUserById(@PathVariable("userId") String userId);
}
