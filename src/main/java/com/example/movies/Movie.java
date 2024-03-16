package com.example.movies;

public class Movie {
    private int idMovie;
    private String nameMovie;
    private int year;
    private String director;
    private String genre;
    private String synopsis;

    // GET METHODS
    public Movie(int idMovie, String nameMovie, int year, String director, String genre, String synopsis){
        this.idMovie = idMovie;
        this.nameMovie = nameMovie;
        this.year = year;
        this.director = director;
        this.genre = genre;
        this.synopsis = synopsis;
    }
    
    // GET METHOD
    public int getIdMovie(){
        return idMovie;
    }

    public String getNameMovie(){
        return nameMovie;
    }

    public int getYearMovie(){
        return year;
    }
    
    public String getDirectorMovie(){
        return director;
    }

    public String getGenreMovie(){
        return genre;
    }

    public String getSynopsisMovie(){
        return synopsis;
    }
}

