package com.hooau.mybatis.base;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>测试基类</P>
 * Created with IDEA
 * author: hooau
 * date: 2016/3/22
 */
public abstract class BaseTest {

    //protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected static SqlSessionFactory factory = getFactory();

    private static SqlSessionFactory getFactory() {
        if(factory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
                factory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                //logger.debug("流读取异常：" + e.getMessage());
            } catch (Exception e) {
                //logger.debug("未知异常：" + e.getMessage());
            }
        }
        return factory;
    }
}
