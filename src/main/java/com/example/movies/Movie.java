package com.example.movies;

public class Movie {
    private int idMovie;
    private String nameMovie;

    // GET METHODS
    public Movie(int idMovie, String nameMovie){
        this.idMovie = idMovie;
        this.nameMovie = nameMovie;
    }

    public int getIdMovie(){
        return idMovie;
    }

    public String getNameMovie(){
        return nameMovie;
    }
}

