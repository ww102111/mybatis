package com.hooau.mybatis.domain;

import java.util.Date;

/**
 * <p>实体：用户</P>
 * Created with IDEA
 * author: hooau
 * date: 2016/3/20
 */
public class User {

    protected Integer id;             //id
    protected String username;    //用户名
    protected String sex;         //性别
    protected Date birthday;      //生日
    protected String address;     //地址

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
