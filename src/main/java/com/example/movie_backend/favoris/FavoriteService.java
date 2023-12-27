package com.example.movie_backend.favoris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public void addToFavorites(Long movieId) {
        if (!favoriteRepository.existsByMovieId(movieId)) {
            Favorite favorite = new Favorite();
            favorite.setMovieId(movieId);
            favoriteRepository.save(favorite);
        } else {
            throw new IllegalArgumentException("Movie already in favorites");
        }
    }

    public Set<Long> getFavoriteMovies() {
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites.stream()
                .map(Favorite::getMovieId)
                .collect(Collectors.toSet());
    }
}
