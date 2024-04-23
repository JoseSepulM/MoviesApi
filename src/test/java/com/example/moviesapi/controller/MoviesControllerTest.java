package com.example.moviesapi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.web.servlet.MockMvc;
import com.example.moviesapi.model.Movie;
import com.example.moviesapi.service.MovieService;
import static org.hamcrest.Matchers.equalTo;


@WebMvcTest(MoviesController.class)
public class MoviesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieServiceMock;

    @Test
    public void obtenerTodosTest() throws Exception {
        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setDirector("Pedro");
        movie1.setGenre("Ciencia ficcion");
        movie1.setSynopsis("Autos que se transforman");
        movie1.setYear(2009);
        movie1.setnamemovie("Transformers");

        List<Movie> movies = List.of(movie1);

        List<EntityModel<Movie>> movieRepository = movies.stream()
        .map(movie -> EntityModel.of(movie))
        .collect(Collectors.toList());

        when(movieServiceMock.getAllMovies()).thenReturn(movies);

        mockMvc.perform(get("/movies"))
        .andExpect(status().isOk())

        .andExpect(jsonPath("$._embedded.movieList.length()").value(equalTo(1)))
        .andExpect(jsonPath("$._embedded.movieList[0].nameMovie").value("Transformers"))
        .andExpect(jsonPath("$._embedded.movieList[0]._links.self.href").value("http://localhost/movies/1"));

    }
}
