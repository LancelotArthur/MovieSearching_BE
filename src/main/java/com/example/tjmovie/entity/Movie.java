package com.example.tjmovie.entity;

import javax.persistence.*;

/**
 * Movie 与 数据库movie映射
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @Column(nullable = false)
    private String id;


    @Column(unique = true)
    private String movieName;
    private String movieFormat;
    private String movieLanguage;
    private String lastTimeMinute;
    private String genres;
    private String mpaaRate;


    public Movie(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieFormat() {
        return movieFormat;
    }

    public void setMovieFormat(String movieFormat) {
        this.movieFormat = movieFormat;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getLastTimeMinute() {
        return lastTimeMinute;
    }

    public void setLastTimeMinute(String lastTimeMinute) {
        this.lastTimeMinute = lastTimeMinute;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getMpaaRate() {
        return mpaaRate;
    }

    public void setMpaaRate(String mpaaRate) {
        mpaaRate = mpaaRate;
    }
}
