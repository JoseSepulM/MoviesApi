package com.example.moviesapi.service;

import com.example.moviesapi.model.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(Long id);
    Movie createMovie(Movie payload);
    Movie updateMovie(Movie payload, Long id);
    void deleteMovie(Long id);
    
} 