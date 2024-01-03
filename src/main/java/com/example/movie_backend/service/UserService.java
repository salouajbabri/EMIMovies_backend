package com.example.movie_backend.service;

import com.example.movie_backend.dto.LoginDto;
import com.example.movie_backend.dto.UserDto;


public interface UserService {
    String addUser(UserDto userDto);

    LoginMesage loginUser(LoginDto loginDto);
}
