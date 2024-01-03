package com.example.movie_backend.dto;

public class UserDto {
    private Long userid;
    private String name;
    private String email;
    private String password;

    public UserDto(Long userid, String name, String email, String password) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDto() {
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
