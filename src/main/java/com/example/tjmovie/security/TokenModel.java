package com.example.tjmovie.security;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 */
public class TokenModel {

    //用户名
    private String userName;

    //随机生成的uuid
    private String token;

    public TokenModel(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
