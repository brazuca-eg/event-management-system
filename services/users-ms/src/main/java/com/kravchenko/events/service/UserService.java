package com.kravchenko.events.service;

import com.kravchenko.events.dto.request.CreateUserRequest;
import com.kravchenko.events.dto.response.UserResponse;
import com.kravchenko.events.exception.UserAlreadyExistsException;

public interface UserService {

    String createUser(CreateUserRequest request) throws UserAlreadyExistsException;

    UserResponse findById(String id);
}
