package com.hooau.mybatis.test.mapper;

import com.hooau.mybatis.domain.User;
import com.hooau.mybatis.extend.UserExtend;
import com.hooau.mybatis.mapper.UserMapper;
import com.hooau.mybatis.wrap.UserWrap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapperTest.class);

    private SqlSessionFactory factory = null;

    /**
     * 在所有测试方法前执行，创建SqlSessionFactory，为单例
     */
    @Before
    public void initialSessionFactory() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            LOGGER.debug("流读取出错" + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.debug("流关闭异常" + e.getMessage());
                }
            }
        }
    }

    @Test
    public void testFindUserById() throws Exception {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //使用Mapper代理
        User user = userMapper.findUserById(1);
        System.out.print(user);
    }

    @Test
    public void testFindUsersByName() throws Exception {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //使用Mapper代理
        List<User> list = userMapper.findUsersByName("柳");
        System.out.print(list);
    }

    @Test
    public void testFindUserList() throws Exception {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        UserWrap userWrap = new UserWrap();
        UserExtend userExtend = new UserExtend();
        userExtend.setUsername("柳");
        userWrap.setUserExtend(userExtend);

        List<User> list = userMapper.findUserList(userWrap);
        session.close();
        System.out.print(list);
    }

    @Test
    public void testFindUserCount() throws Exception {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        UserWrap userWrap = new UserWrap();
        UserExtend userExtend = new UserExtend();
        userExtend.setUsername("柳");
        userWrap.setUserExtend(userExtend);

        int count = userMapper.findUserCount(userWrap);
        session.close();
        System.out.print(count);
    }

    @Test
    public void testFindUserResultMap() throws Exception {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        UserWrap userWrap = new UserWrap();
        UserExtend userExtend = new UserExtend();
        userExtend.setUsername("柳");
        userWrap.setUserExtend(userExtend);

        List<User> list = userMapper.findUserResultMap(userWrap);
        session.close();
        System.out.print(list);
    }

    @Test
    public void testFindUserSqlPart() throws Exception {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        UserWrap userWrap = new UserWrap();
        UserExtend userExtend = new UserExtend();
        userExtend.setUsername("柳");
        userExtend.setSex("1");
        userWrap.setUserExtend(userExtend);

        List<User> userList = userMapper.findUserSqlPart(userWrap);
        session.close();
        System.out.print(userList);
    }

    @Test
    public void testFindUserByIds() throws Exception {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        UserWrap userWrap = new UserWrap();
        UserExtend userExtend = new UserExtend();
        userExtend.setUsername("柳");
        userWrap.setUserExtend(userExtend);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(28);
        userWrap.setIds(ids);

        List<User> userList = userMapper.findUserSqlPart(userWrap);
        session.close();
        System.out.print(userList);
    }
}
