package com.example.moviesapi.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;






@RestController
@RequestMapping("/movies")
public class MoviesController {

    private static final Logger log = LoggerFactory.getLogger(MoviesController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public CollectionModel<EntityModel<Movie>> getMovies() {
        List<Movie> movies = movieService.getAllMovies();
        log.info("GET /movies");
        log.info("Retornando todas las pelicualas");

        List<EntityModel<Movie>> moviesResources = movies.stream()
        .map( movie -> EntityModel.of(movie,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMovieById(movie.getId())).withSelfRel()
        ))
        .collect(Collectors.toList());
       
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMovies());
        CollectionModel<EntityModel<Movie>> resources = CollectionModel.of(moviesResources, linkTo.withRel("movies"));

        return resources;
    }

    @GetMapping("/{idMovie}")
    public ResponseEntity<?> getMovieById(@PathVariable Long idMovie) {
        Optional<Movie> movie = movieService.getMovieById(idMovie);
        if(movie.isEmpty()){
            log.error("No se encontro la pelicula con id {}",idMovie);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Movie not found with id: " + idMovie));

            // return ResponseEntity.notFound().build();
        }

        log.info("Pelicula encontrada");
        return ResponseEntity.ok(movie);

    
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
    

    static class ErrorResponse{
        private final String message;
        
        public ErrorResponse(String message){
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}