package com.hooau.mybatis.test.mapper;

import com.hooau.mybatis.base.BaseTest;
import com.hooau.mybatis.domain.User;
import com.hooau.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * <p>mybatis一级缓存</P>
 * Created with IDEA
 * author: hooau
 * date: 2016/3/25
 */
public class CacheTest extends BaseTest{

    @Test
    public void testCache() throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        System.out.println(user);

        //获取user2的时候，控制台并没有打印sql语句，mybatis使用一级缓存
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);

        sqlSession.close();
    }

    /**
     * 二级缓存配置
     *  SqlMapConfig.xml
     *  mapper中配置
     * 注意：二级需要实体实现序列化接口
     * @throws Exception
     */
    @Test
    public void testSecondLevelCache() throws Exception {
        SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        System.out.println(user);

        //获取user2的时候，控制台并没有打印sql语句，mybatis使用一级缓存
        User user2 = userMapper2.findUserById(1);
        System.out.println(user2);

        sqlSession.close();
        sqlSession2.close();
    }
}
