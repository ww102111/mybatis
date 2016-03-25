package com.hooau.mybatis.mapper;

import com.hooau.mybatis.domain.Orders;
import com.hooau.mybatis.extend.OrderExtend;

import java.util.List;

/**
 * <p>订单mapper</P>
 * Created with IDEA
 * author: hooau
 * date: 2016/3/22
 */
public interface OrderMapper {

    /**
     * 查询订单及相关用户的信息
     *
     * @return
     * @throws Exception
     */
    List<OrderExtend> findOrderAndUser() throws Exception;

    /**
     * 使用resultMap查询订单用户信息
     * @return
     * @throws Exception
     */
    List<Orders> findOrderUserResultMap() throws Exception;

}
