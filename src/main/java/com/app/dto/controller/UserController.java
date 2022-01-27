package com.app.dto.controller;

import com.app.dto.dto.UserLocationDTO;
import com.app.dto.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users-location")
    public List<UserLocationDTO> getAllUsersLocation() {
        return userService.getAllUsersLocations();
    }
}
