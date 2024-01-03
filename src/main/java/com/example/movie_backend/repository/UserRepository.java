package com.example.movie_backend.repository;

import com.example.movie_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
