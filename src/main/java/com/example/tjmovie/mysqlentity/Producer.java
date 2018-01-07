package com.example.tjmovie.mysqlentity;

import javax.persistence.*;


@Entity
@Table(name = "producer")
public class Producer {

    @Id
    private int ID;

    private String ASIN;

    private String producer;

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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
