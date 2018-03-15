package com.ccy.controller;

import com.ccy.dto.OrderDTO;
import com.ccy.enums.ResultEnum;
import com.ccy.exception.SellException;
import com.ccy.service.OrderService;
import com.ccy.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.util.Map;

/**
 * Created by ccy on 2018/2/9.
 */
@Controller
@Slf4j
//@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/pay")
    public ModelAndView index(@RequestParam("openid") String openid,
                              @RequestParam("orderId") String orderId,
                              @RequestParam("returnUrl") String returnUrl,
                              Map<String,Object> map){
        log.info("【openid】:={}",openid);
        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);

        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse",payResponse);
        returnUrl = URLDecoder.decode(returnUrl);
        map.put("returnUrl",returnUrl);

        return new ModelAndView("pay/create",map);
    }

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){
        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);

        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);

        return new ModelAndView("pay/create",map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);

        //返回微信处理结果
        return new ModelAndView("pay/success");
    }
}
