package com.example.movie_backend.controller;

import com.example.movie_backend.entity.Favorite;
import com.example.movie_backend.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:80")
public class FavoriteController {



    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteController(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }
    @PostMapping("/favorites/add")
    public ResponseEntity<String> addToFavorites(@RequestBody Map<String, Object> payload) {
        try {
            // Extract movieId from the request payload
            Long movieId = Long.valueOf(payload.get("movieId").toString());

            // Check if the movieId already exists in favorites (you may customize this logic)
            if (favoriteRepository.existsByMovieId(movieId)) {
                return ResponseEntity.badRequest().body("Movie already in favorites");
            }

            // Create a Favorite entity and save it to the database
            Favorite favorite = new Favorite();
            favorite.setMovieId(movieId);

            favoriteRepository.save(favorite);

            return ResponseEntity.ok("Added to favorites successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error");
        }
    }

    @GetMapping("/favorites/get")
    public ResponseEntity<List<Favorite>> getFavoriteMovies() {
        List<Favorite> favoriteMovies = favoriteRepository.findAll();

        return ResponseEntity.ok(favoriteMovies);
    }
}
