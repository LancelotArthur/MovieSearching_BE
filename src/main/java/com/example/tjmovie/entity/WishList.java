package com.example.tjmovie.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * WishList 与 数据库wish_list映射
 */
@Entity
@Table(name = "wish_list")
@IdClass(WishList.class)
public class WishList implements Serializable {

    @Id
    @Column(nullable = false)
    private String userId;

    @Id
    @Column(nullable = false)
    private String movieId;

    public WishList(){

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
        if(obj instanceof WishList){

            WishList wishList = (WishList) obj;

            if(this.userId.equals(wishList.getUserId()) && this.movieId.equals(wishList.getMovieId()) ){
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
