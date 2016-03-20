package com.hooau.mybatis.mapper;

import com.hooau.mybatis.domain.User;
import com.hooau.mybatis.wrap.UserWrap;

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

    /**
     * 使用包装类型查找用户列表
     * @param userWrap
     * @return
     * @throws Exception
     */
    List<User> findUserList(UserWrap userWrap) throws Exception;

    /**
     * 查找用户数量
     * @param userWrap
     * @return
     * @throws Exception
     */
    int findUserCount(UserWrap userWrap) throws Exception;

    /**
     * 当表列名和实体属性名不一致时查询用户列表
     * 那么使用ResultMap对结果集进行映射
     * @param userWrap
     * @return
     * @throws Exception
     */
    List<User> findUserResultMap(UserWrap userWrap) throws Exception;

    /**
     * 使用sql片段查询用户列表
     * @param userWrap
     * @return
     * @throws Exception
     */
    List<User> findUserSqlPart(UserWrap userWrap) throws Exception;
}
