package com.ccy.service.impl;

import com.ccy.dto.OrderDTO;
import com.ccy.service.OrderService;
import com.ccy.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by ccy on 2018/2/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1507097658334341062");
        payService.create(orderDTO);
    }

    @Test
    public void refund() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1520955930125151992");
        payService.refund(orderDTO);
    }
}