package com.example.tjmovie.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Director 与 数据库directors映射
 */
@Entity
@Table(name = "directors")
@IdClass(Director.class)
public class Director implements Serializable {

    @Id
    @Column(nullable = false)
    private String cbId;

    @Id
    @Column(nullable = false)
    private String movieId;

    public Director(){

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
        if(obj instanceof Director){

            Director director = (Director) obj;

            if(this.cbId.equals(director.getCbId()) && this.movieId.equals(director.getMovieId())){
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
