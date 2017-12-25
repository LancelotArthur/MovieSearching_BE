package com.example.tjmovie.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Writer 与 数据库writers映射
 */
@Entity
@Table(name = "writers")
@IdClass(Writer.class)
public class Writer implements Serializable {

    @Id
    @Column(nullable = false)
    private String cbId;

    @Id
    @Column(nullable = false)
    private String movieId;

    public Writer(){

    }

    public String getCbId() {
        return cbId;
    }

    public void setCbId(String cbId) {
        this.cbId = cbId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Writer){

            Writer writer = (Writer) obj;

            if(this.cbId.equals(writer.getCbId()) && this.movieId.equals(writer.getMovieId()) ){
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return  super.hashCode();
    }

}
