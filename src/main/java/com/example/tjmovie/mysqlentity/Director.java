package com.example.tjmovie.mysqlentity;

import javax.persistence.*;


@Entity
@Table(name = "director")
public class Director {

    @Id
    private int id;

    private String asin;

    private String director;

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
