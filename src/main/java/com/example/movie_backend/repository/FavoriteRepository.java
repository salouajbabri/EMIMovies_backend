package com.example.movie_backend.repository;

import com.example.movie_backend.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long>{

    boolean existsByMovieId(Long movieId);

    List<Favorite> findAllByMovieId(Long movieId);
}
