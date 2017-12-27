package com.example.tjmovie.entity;


import javax.persistence.*;

/**
 * Celebrity 与 数据库celebrity映射
 */
@Entity
@Table(name = "celebrity")
public class Celebrity {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private String id;

    private String name;
    private String headImg;
    private String briefIntroduction;
    private String gender;
    private String birthday;
    private String nation;
    private boolean isWriter;
    private boolean isDirector;
    private boolean isActor;
    private boolean isProducer;

    public Celebrity(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public boolean isWriter() {
        return isWriter;
    }

    public void setWriter(boolean writer) {
        isWriter = writer;
    }

    public boolean isDirector() {
        return isDirector;
    }

    public void setDirector(boolean director) {
        isDirector = director;
    }

    public boolean isActor() {
        return isActor;
    }

    public void setActor(boolean actor) {
        isActor = actor;
    }

    public boolean isProducer() {
        return isProducer;
    }

    public void setProducer(boolean producer) {
        isProducer = producer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
