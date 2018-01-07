package com.example.tjmovie.mysqlentity;

import javax.persistence.*;


@Entity
@Table(name = "movie_dvd")
public class MovieDvd {

    @Id
    private int id;

    private String asin;

    private String movie;

    private String studio;

    private String mpaaRating;

    private String captionsAndSubtitles;

    private String purchaseRight;

    private String format;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getCaptionsAndSubtitles() {
        return captionsAndSubtitles;
    }

    public void setCaptionsAndSubtitles(String captionsAndSubtitles) {
        this.captionsAndSubtitles = captionsAndSubtitles;
    }

    public String getPurchaseRight() {
        return purchaseRight;
    }

    public void setPurchaseRight(String purchaseRight) {
        this.purchaseRight = purchaseRight;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
