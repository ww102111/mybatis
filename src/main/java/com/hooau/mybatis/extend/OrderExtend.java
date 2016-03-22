package com.hooau.mybatis.extend;

import com.hooau.mybatis.domain.Orders;

/**
 * <p>订单的扩展对象</P>
 * Created with IDEA
 * author: hooau
 * date: 2016/3/22
 */
public class OrderExtend extends Orders{

    private String username;
    private String sex;

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

    @Override
    public String toString() {
        return "[id="+this.id+", " +
                "username="+this.username+", " +
                "sex="+this.sex+"]";
    }
}
