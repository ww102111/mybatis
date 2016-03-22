package com.hooau.mybatis.Base;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>测试基类</P>
 * Created with IDEA
 * author: hooau
 * date: 2016/3/22
 */
public class BaseTest{

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected SqlSessionFactory factory = getFactory();

    private SqlSessionFactory getFactory() {
        if(factory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
                factory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                logger.debug("流读取异常：" + e.getMessage());
            } catch (Exception e) {
                logger.debug("未知异常：" + e.getMessage());
            }
        }
        return factory;
    }
}
