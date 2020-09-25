package com.huike.ycu.mybatis.model;

import java.io.Serializable;

public class Customer implements Serializable {

    private Long id;
    private  String username;
    private  String password;
    private  String sex;
    private  String nickname;


    public Customer() {
    }

    public Customer(String username, String password, String sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
