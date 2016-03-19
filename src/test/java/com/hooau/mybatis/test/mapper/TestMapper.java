package com.hooau.mybatis.test.mapper;

import com.hooau.mybatis.domain.User;
import com.hooau.mybatis.mapper.UserMapper;
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
import java.util.List;

/**
 * Created by hooau on 2016/3/19.
 */
public class TestMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestMapper.class);

    private SqlSessionFactory factory = null;

    /**
     * 在所有测试方法前执行，创建SqlSessionFactory
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
}
