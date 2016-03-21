package com.hooau.mybatis.wrap;

import com.hooau.mybatis.domain.User;
import com.hooau.mybatis.extend.UserExtend;

import java.util.List;

/**
 * <p>用户的包装对象</P>
 * Created with IDEA
 * author: hooau
 * date: 2016/3/20
 */
public class UserWrap {

    private User user;
    private UserExtend userExtend;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserExtend getUserExtend() {
        return userExtend;
    }

    public void setUserExtend(UserExtend userExtend) {
        this.userExtend = userExtend;
    }

}
