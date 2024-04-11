package com.example.moviesapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovie")
    private Long idmovie;

    @Column(name = "namemovie")
    private String namemovie;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "director")
    private String director;

    @Column(name = "genre")
    private String genre;

    @Column(name = "synopsis")
    private String synopsis;
    

    // Getters and Setters

    public Long getId(){
        return idmovie;
    }

    public String getNameMovie(){
        return namemovie;
    }

    public Integer getAnio(){
        return anio;
    }

    public String getDirector(){
        return director;
    }

    public String getGenre(){
        return genre;
    }

    public String getSynopsis(){
        return synopsis;
    }

    // SET

    public void setId(Long idMovie){
        this.idmovie = idMovie;
    }

    public void setnamemovie(String namemovie){
        this.namemovie = namemovie;
    }

    public void setYear(Integer anio){
        this.anio = anio;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }
}