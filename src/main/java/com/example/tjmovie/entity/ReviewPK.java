package com.example.tjmovie.entity;

import javax.persistence.IdClass;
import java.io.Serializable;

@IdClass(ReviewPK.class)
public class ReviewPK implements Serializable {
    private String movieId;

    private String userId;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof ReviewPK){

            ReviewPK reviewPK = (ReviewPK)obj;

            if(this.movieId.equals(reviewPK.getMovieId()) && this.userId.equals(reviewPK.getUserId()) ){
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
