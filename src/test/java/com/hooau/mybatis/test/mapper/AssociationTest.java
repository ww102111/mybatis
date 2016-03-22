package com.hooau.mybatis.test.mapper;

import com.hooau.mybatis.base.BaseTest;
import com.hooau.mybatis.extend.OrderExtend;
import com.hooau.mybatis.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * <p>复杂查询测试</P>
 * Created with IDEA
 * author: hooau
 * date: 2016/3/22
 */
public class AssociationTest extends BaseTest {

    @Test
    public void testFindOrderAndUser() {
        SqlSession session = factory.openSession();
        OrderMapper ordersMapper = session.getMapper(OrderMapper.class);
        List<OrderExtend> orderExtends = null;
        try {
            orderExtends = ordersMapper.findOrderAndUser();
        } catch (Exception e) {
            //logger.debug("测试查询订单异常" + e.getMessage());
        }
        System.out.println(orderExtends);
    }
}
