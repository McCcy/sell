package com.ccy.service;

import com.ccy.dto.OrderDTO;

/**
 * Created by ccy on 2018/2/4.
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
