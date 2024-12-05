package com.collabor8.service;

import com.collabor8.dto.UserDto;
import com.collabor8.entity.User;
import com.collabor8.exception.UserNotFoundException;
import com.collabor8.exception.UserNotRegistered;
import com.collabor8.exception.UserNotUpdatedException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.collabor8.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    // Register a new user
    public void registerUser(UserDto userDto) {
        try {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
        } catch (Exception e) {
            throw new UserNotRegistered(e);
        }
    }

    //Update user
    public void updateUser(Long userId, UserDto userDto) {
        try {
            User user = userRepository.getReferenceById(userId);
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
        } catch (Exception e) {
            throw new UserNotUpdatedException(e);
        }
    }

    // Delete user
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
    }
}
