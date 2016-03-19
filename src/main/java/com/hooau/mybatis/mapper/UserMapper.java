package com.hooau.mybatis.mapper;

import com.hooau.mybatis.domain.User;

import java.util.List;

/**
 * UserMapper
 * @author hooau
 * @date 2016/3/20
 */
public interface UserMapper {

    /**
     * 根据id查找用户
     * @param id
     * @throws Exception
     */
    User findUserById(int id) throws Exception;

    /**
     * 根据用户名查找多个用户
     * @return
     * @throws Exception
     */
    List<User> findUsersByName(String username) throws Exception;
}
