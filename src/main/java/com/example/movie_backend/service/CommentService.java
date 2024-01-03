package com.example.movie_backend.service;

import com.example.movie_backend.entity.Comment;
import com.example.movie_backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {

        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByIdmovie(Long idmovie) {
        return commentRepository.findByIdmovie(idmovie);
    }


}
