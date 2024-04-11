package com.example.moviesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviesapi.repository.MovieRepository;
import com.example.moviesapi.model.Movie;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }

    @Override
    public Movie createMovie(Movie payload)
    {
        return movieRepository.save(payload);
    }

    @Override
    public Movie updateMovie(Movie payload, Long id){
        if(movieRepository.existsById(id)){
            payload.setId(id);
            return movieRepository.save(payload);
        }

        return null;
    }

    @Override
    public void deleteMovie(Long idMovie){
        movieRepository.deleteById(idMovie);
    }


}