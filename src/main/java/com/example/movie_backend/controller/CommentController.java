package com.example.movie_backend.controller;

import com.example.movie_backend.service.CommentService;
import com.example.movie_backend.entity.Comment;
import com.example.movie_backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:80")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;
    @PostMapping("/comments/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/comments/get")
    public ResponseEntity<List<Comment>> getCommentsByIdmovie(@RequestParam Long idmovie) {
        List<Comment> comments = commentService.getCommentsByIdmovie(idmovie);
        return ResponseEntity.ok(comments);
    }

}