package com.example.movie_backend.repository;

import com.example.movie_backend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {


    List<Comment> findByIdmovie(Long idmovie);
}
