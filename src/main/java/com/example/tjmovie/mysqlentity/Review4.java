package com.example.tjmovie.mysqlentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "review4")
public class Review4 {

    @Id
    private int id;

    private String productId;

    private String userId;

    private String profileName;

    private String helpfulness;

    private int helpfulness1;

    private int helpfulness2;

    private double score;

    private int time;

    private String summary;

    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getHelpfulness() {
        return helpfulness;
    }

    public void setHelpfulness(String helpfulness) {
        this.helpfulness = helpfulness;
    }

    public int getHelpfulness1() {
        return helpfulness1;
    }

    public void setHelpfulness1(int helpfulness1) {
        this.helpfulness1 = helpfulness1;
    }

    public int getHelpfulness2() {
        return helpfulness2;
    }

    public void setHelpfulness2(int helpfulness2) {
        this.helpfulness2 = helpfulness2;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
