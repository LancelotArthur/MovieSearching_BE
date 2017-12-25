package com.example.tjmovie.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Actor 与 数据库actors映射


 * 多主键需要实现 Serializable
 * 并且实现equals 和 hashCode
 */
@Entity
@Table(name = "actors")
@IdClass(Actor.class)
public class Actor implements Serializable{

    @Id
    @Column(nullable = false)
    private String cbId;

    @Id
    @Column(nullable = false)
    private String movieId;

    public Actor(){

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
        if(obj instanceof Actor){

            Actor actor = (Actor) obj;

            if(this.cbId.equals(actor.getCbId()) && this.movieId.equals(actor.getMovieId())){
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
