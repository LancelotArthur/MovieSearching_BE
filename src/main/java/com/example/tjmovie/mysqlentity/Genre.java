package com.example.tjmovie.mysqlentity;


import javax.persistence.*;


@Entity
@Table(name = "genre")
public class Genre {

    @Id
    private int id;

    private String genre;

    private String asin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }
}
