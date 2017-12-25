package com.example.tjmovie.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Account 与 数据库user_account映射
 */
@Entity
@Table(name = "user_account")
public class Account {

    @Id
    @Column(nullable = false)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(unique = true)
    private String userName;
    private String userPassword;

    @Column(unique = true)
    private String email;

    private String headImg;

    private String briefIntroduction;

    private Date createTime;

    private Date updateTime;


    public Account() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
