package com.example.tjmovie.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Producer 与 数据库producers映射
 */
@Entity
@Table(name = "producers")
@IdClass(Producer.class)
public class Producer implements Serializable {

    @Id
    @Column(nullable = false)
    private String cbId;

    @Id
    @Column(nullable = false)
    private String movieId;

    public Producer(){

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
        if(obj instanceof Producer){

            Producer producer = (Producer) obj;

            if(this.cbId.equals(producer.getCbId()) && this.movieId.equals(producer.getMovieId()) ){
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
