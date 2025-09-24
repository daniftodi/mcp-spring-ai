package com.iftodi.dan.spring_mcp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iftodi.dan.spring_mcp.model.User;
import com.iftodi.dan.spring_mcp.service.UserService;

@Component
public class UserMcpController {

    private final UserService userService;

    @Autowired
    public UserMcpController(UserService userService) {
        this.userService = userService;
    }

    @Tool(
        name = "getAllUsers",
        description = "Retrieves all users information. Returns user details including ID, name, " +
            "email, and status."
    )
    public List<User> getAllUsers() {
        return new ArrayList<>(userService.getAllUsers().values());
    }

    @Tool(
        name = "getUser",
        description = "Retrieves user information by email address. Returns user details including ID, name, email, and status."
    )
    public User getUser(String email) {
        return userService.getUserByEmail(email);
    }

    @Tool(
        name = "createUser",
        description = "Creates a new user with the provided email, first name, and last name."
    )
    public User createUser(String email, String firstName, String lastName) {
        return userService.createUser(email, firstName, lastName);
    }

    @Tool(
        name = "userExists",
        description = "Checks if a user exists with the given email address."
    )
    public boolean userExists(String email) {
        return userService.getUser(email).isPresent();
    }
}
