package com.example.movies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class MovieController {
    
    private List<Movie> movies = new ArrayList<>();

    public MovieController(){
        movies.add(new Movie(1, "Shrek"));
        movies.add(new Movie(2, "Shrek 2"));
        movies.add(new Movie(1, "Shrek 3"));
    }

    @GetMapping("movies")
    public List<Movie> getListMovies() {
        return movies;
    }
    

    @GetMapping("movies/{id}")
    public Movie getMovieById(@PathVariable int id) {
        for(Movie movie : movies){
            if(movie.getIdMovie() == id){
                return movie;
            }
        }
        return null;
    }
    

}
