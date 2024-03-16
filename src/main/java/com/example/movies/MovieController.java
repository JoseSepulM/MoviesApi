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
        movies.add(new Movie(1, "Shrek", 2001, "Andrew Adamson", "Animación", "Un ogro con un burro"));
        movies.add(new Movie(2, "The Dark Knight", 2008, "Christopher Nolan", "Acción", "Batman enfrenta al Joker"));
        movies.add(new Movie(3, "Forrest Gump", 1994, "Robert Zemeckis", "Drama", "La vida de un hombre con discapacidad intelectual"));
        movies.add(new Movie(4, "Inception", 2010, "Christopher Nolan", "Ciencia ficción", "Robando secretos del subconsciente"));
        movies.add(new Movie(5, "Pulp Fiction", 1994, "Quentin Tarantino", "Crimen", "Historias entrelazadas en Los Ángeles"));
        movies.add(new Movie(6, "The Shawshank Redemption", 1994, "Frank Darabont", "Drama", "La vida en una prisión"));
        movies.add(new Movie(7, "The Lord of the Rings: The Fellowship of the Ring", 2001, "Peter Jackson", "Fantasía", "Una aventura épica"));
        movies.add(new Movie(8, "The Matrix", 1999, "The Wachowskis", "Ciencia ficción", "La realidad es una simulación"));
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
