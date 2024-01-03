package com.example.movie_backend.service;

import com.example.movie_backend.dto.LoginDto;
import com.example.movie_backend.dto.UserDto;
import com.example.movie_backend.entity.User;
import com.example.movie_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //public PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserid(),
                userDto.getName(),
                userDto.getEmail(),
                // Uncomment the next line when using PasswordEncoder
                //this.passwordEncoder.encode(userDto.getPassword())
                userDto.getPassword()
        );

        userRepository.save(user);
        return user.getName();
    }

    @Override
    public LoginMesage loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            // Uncomment the next line when using PasswordEncoder
            //Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            Boolean isPwdRight = password.equals(encodedPassword);

            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
                return new LoginMesage("Password Not Match", false);
            }
        } else {
            return new LoginMesage("Email not exists", false);
        }
    }
}
