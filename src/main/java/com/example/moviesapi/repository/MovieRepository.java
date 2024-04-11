package com.example.moviesapi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.moviesapi.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}