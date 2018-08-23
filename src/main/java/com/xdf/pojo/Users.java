package com.xdf.pojo;

import java.io.Serializable;

/**
 * 实体类用户的
 */
public class Users implements Serializable {
    private int id;
    private  String userName;
    private  String password;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users() {

    }

    public Users(int id, String userName, String password) {

        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
