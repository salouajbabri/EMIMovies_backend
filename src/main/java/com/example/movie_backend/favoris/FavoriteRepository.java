package com.example.movie_backend.favoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long>{

    boolean existsByMovieId(Long movieId);
}
