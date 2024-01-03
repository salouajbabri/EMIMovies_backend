package com.example.movie_backend.controller;

import com.example.movie_backend.dto.LoginDto;
import com.example.movie_backend.dto.UserDto;
import com.example.movie_backend.service.LoginMesage;
import com.example.movie_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "http://localhost:80")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/save")
    public String saveUser(@RequestBody UserDto userDto) {
        String id = userService.addUser(userDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        LoginMesage loginMesage = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginMesage);
    }
}
