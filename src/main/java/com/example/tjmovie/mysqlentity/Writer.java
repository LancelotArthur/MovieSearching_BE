package com.example.tjmovie.mysqlentity;

import javax.persistence.*;


@Entity
@Table(name = "writer")
public class Writer {

    @Id
    private int ID;

    private String ASIN;

    private String writer;

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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
