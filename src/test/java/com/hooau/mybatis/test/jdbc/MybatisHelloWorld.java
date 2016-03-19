package com.hooau.mybatis.test.jdbc;

import com.hooau.mybatis.domain.User;
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
import java.util.Date;
import java.util.List;

/**
 * Created by hooau on 2016/3/19.
 */
public class MybatisHelloWorld {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisHelloWorld.class);

    private SqlSessionFactory factory = null;

    /**
     * 在所有测试方法前执行，创建SqlSessionFactory
     */
    @Before
    public void buildSessionFactory() {
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
                    LOGGER.debug("关闭流出错" + e.getMessage());
                }
            }
        }
    }

    /**
     * 测试查询单条数据
     */
    @Test
    public void testFindUserById() {
        SqlSession session = null;
        User user = null;
        try {
            session = factory.openSession();
            user = session.selectOne("test.findUserById", 2);
        } catch (Exception e) {
            LOGGER.debug("查询出错：" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.print(user);
    }

    /**
     * 测试查询多条数据
     */
    @Test
    public void testFindUsersByName() {
        SqlSession session = null;
        List<User> list = null;
        try {
            session = factory.openSession();
            list = session.selectList("test.findUsersByName", "小明");
        } catch (Exception e) {
            LOGGER.debug("查询出错：" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println(list.get(0));
    }

    /**
     * 测试插入数据
     */
    @Test
    public void testInsertUser() {
        SqlSession session = null;
        User user = null;
        try {
            session = factory.openSession();

            user = new User();
            user.setUsername("柳柳");
            user.setAddress("沪C");
            user.setBirthday(new Date());
            user.setSex("1");

            //注意，这里session要手动提交，否则不报错但是插入不成功
            session.insert("test.insertUser", user);
            session.commit();
        } catch (Exception e) {
            LOGGER.debug("新增用户出错：" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        //user.xml设置逐渐返回
        System.out.println(user.getId());
    }

    /**
     * 测试删除数据
     */
    @Test
    public void testDeleteUser() {
        SqlSession session = null;
        try {
            session = factory.openSession();
            session.delete("test.deleteById", 29);
            session.commit();
        } catch (Exception e) {
            LOGGER.debug("删除用户出错：" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 测试插入数据
     */
    @Test
    public void testUpdateUser() {
        SqlSession session = null;
        try {
            session = factory.openSession();

            User user = new User();
            user.setId(31);
            user.setSex("1");
            user.setBirthday(new Date());
            user.setUsername("Jerry");
            user.setAddress("呼呼C");

            session.update("test.updateUser", user);
            session.commit();
        } catch (Exception e) {
            LOGGER.debug("更新用户出错：" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
