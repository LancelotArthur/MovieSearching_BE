package com.example.tjmovie.mysqlentity;

import javax.persistence.*;


@Entity
@Table(name = "actor")
public class Actor {

    @Id
    private int ID;

    private String ASIN;

    private String actor;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String ASIN) {
        this.ASIN = ASIN;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
