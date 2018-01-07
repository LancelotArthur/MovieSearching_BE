package com.example.tjmovie.mysqlentity;

import javax.persistence.*;


@Entity
@Table(name = "movie2review")
public class Movie2review {

    @Id
    private String asin;

    private int id;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
