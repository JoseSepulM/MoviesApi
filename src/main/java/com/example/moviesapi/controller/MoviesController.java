package com.example.moviesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviesapi.model.Movie;
import com.example.moviesapi.service.MovieService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MovieService movieService;

    @GetMapping()
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{idMovie}")
    public Optional<Movie> getMovieById(@PathVariable Long idMovie) {
        return movieService.getMovieById(idMovie);
    }

    @PostMapping()
    public Movie addMovie(@RequestBody Movie payload) {
        return movieService.createMovie(payload);
    }

    @PutMapping("/{idMovie}")
    public Movie updateMovie(@RequestBody Movie payload, @PathVariable Long idMovie) {
        return movieService.updateMovie(payload, idMovie);
    }

    @DeleteMapping("/{idMovie}")
    public void deleteMovie(@PathVariable Long idMovie){
        movieService.deleteMovie(idMovie);
    }
    
    

    
}