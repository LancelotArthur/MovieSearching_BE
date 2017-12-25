package com.example.tjmovie.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * SeenList 与 数据库seen_list映射
 */
@Entity
@Table(name = "seen_list")
@IdClass(SeenList.class)
public class SeenList implements Serializable {

    @Id
    @Column(nullable = false)
    private String userId;

    @Id
    @Column(nullable = false)
    private String movieId;

    public SeenList(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof SeenList){

            SeenList seenList = (SeenList) obj;

            if(this.userId.equals(seenList.getUserId()) && this.movieId.equals(seenList.getMovieId()) ){
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
