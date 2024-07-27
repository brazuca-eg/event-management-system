package com.kravchenko.events.users_ms.service;

import com.kravchenko.events.users_ms.dto.request.CreateUserRequest;
import com.kravchenko.events.users_ms.dto.response.UserResponse;
import com.kravchenko.events.users_ms.exception.UserAlreadyExistsException;

public interface UserService {

    String createUser(CreateUserRequest request) throws UserAlreadyExistsException;

    UserResponse findById(String id);
}
