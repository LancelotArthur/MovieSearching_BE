package com.example.tjmovie.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Review 与 数据库review映射
 */
@Entity
@Table(name = "review")
@IdClass(ReviewPK.class)
public class Review {

    @Id
    @Column(unique = true)
    private String movieId;

    @Id
    @Column(unique = true)
    private String userId;

    @Column(unique = true)
    private String userName;

    private int helpfulness;

    private int helpTotal;

    private int score;

    private Date reviewTime;

    private String summary;

    private String reviewText;

    private String movieLabel;

    public Review(){

    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHelpfulness() {
        return helpfulness;
    }

    public void setHelpfulness(int helpfulness) {
        this.helpfulness = helpfulness;
    }

    public int getHelpTotal() {
        return helpTotal;
    }

    public void setHelpTotal(int helpTotal) {
        this.helpTotal = helpTotal;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getMovieLabel() {
        return movieLabel;
    }

    public void setMovieLabel(String movieLabel) {
        this.movieLabel = movieLabel;
    }


}
