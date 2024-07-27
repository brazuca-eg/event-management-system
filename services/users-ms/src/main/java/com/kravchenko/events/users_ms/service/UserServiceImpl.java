package com.kravchenko.events.users_ms.service;

import com.kravchenko.events.users_ms.dto.response.UserResponse;
import com.kravchenko.events.users_ms.entity.ServiceUser;
import com.kravchenko.events.users_ms.exception.UserAlreadyExistsException;
import com.kravchenko.events.users_ms.exception.UserNotFoundException;
import com.kravchenko.events.users_ms.repository.UserRepository;
import com.kravchenko.events.users_ms.dto.request.CreateUserRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String createUser(CreateUserRequest request) throws UserAlreadyExistsException {
        if (userRepository.existsByEmailIgnoreCase(request.email())) {
            throw new UserAlreadyExistsException("Email already taken in the system.");
        }

        ServiceUser user = new ServiceUser();
        user.setEmail(request.email());
        user.setName(request.name());
        user.setSurname(request.surname());

        ServiceUser serviceUser = userRepository.save(user);
        return serviceUser.getId();
    }

    @Override
    public UserResponse findById(String id) {
        ServiceUser user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("There is no user with the provided id."));

        return new UserResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail());
    }

}
