package com.example.movie_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usermovie")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    @Column
    private String name ;

    @Column
    private String email;

    @Column
    private String password;

    public User(Long userid, String name, String email, String password) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User() {

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



    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
