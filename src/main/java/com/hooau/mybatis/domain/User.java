package com.hooau.mybatis.domain;

import java.util.Date;

/**
 * Created by hooau on 2016/3/19.
 */
public class User {

    private int id;             //id
    private String username;    //用户名
    private String sex;         //性别
    private Date birthday;      //生日
    private String address;     //地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "[id = "+this.id+", " +
                "username = "+this.username+", " +
                "sex = "+this.sex+", " +
                "address = "+this.address+"]";
    }
}
