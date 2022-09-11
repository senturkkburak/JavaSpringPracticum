package com.project.javaspringpracticum.services;
import com.project.javaspringpracticum.entities.User;
import com.project.javaspringpracticum.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }


    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
