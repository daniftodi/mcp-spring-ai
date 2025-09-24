package com.iftodi.dan.spring_mcp.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iftodi.dan.spring_mcp.model.User;

@Service
public class UserService {

    private final Map<String, User> userStorage = new HashMap<>();

    public UserService() {
        initializeSampleUsers();
    }

    private void initializeSampleUsers() {
        User user1 = new User("1", "john.doe@example.com", "John", "Doe",
                             LocalDateTime.now().minusDays(30), LocalDateTime.now().minusDays(1), true);
        User user2 = new User("2", "jane.smith@example.com", "Jane", "Smith",
                             LocalDateTime.now().minusDays(15), LocalDateTime.now().minusDays(2), true);
        User user3 = new User("3", "bob.wilson@example.com", "Bob", "Wilson",
                             LocalDateTime.now().minusDays(7), LocalDateTime.now().minusDays(3), false);

        userStorage.put("john.doe@example.com", user1);
        userStorage.put("jane.smith@example.com", user2);
        userStorage.put("bob.wilson@example.com", user3);
    }

    public Optional<User> getUser(String email) {
        if (email == null || email.trim().isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(userStorage.get(email.toLowerCase().trim()));
    }

    public User getUserByEmail(String email) {
        return getUser(email).orElse(null);
    }

    public User createUser(String email, String firstName, String lastName) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        String normalizedEmail = email.toLowerCase().trim();

        if (userStorage.containsKey(normalizedEmail)) {
            throw new IllegalArgumentException("User with email " + email + " already exists");
        }

        User newUser = new User();
        newUser.setId(String.valueOf(userStorage.size() + 1));
        newUser.setEmail(normalizedEmail);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());
        newUser.setActive(true);

        userStorage.put(normalizedEmail, newUser);
        return newUser;
    }

    public Map<String, User> getAllUsers() {
        return new HashMap<>(userStorage);
    }
}
