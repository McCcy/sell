package com.ccy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ccy on 2018/2/8.
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
      log.info("进入auth方法。。。");
      log.info("code = {}" , code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxac3f08dd165682f2&secret=a130f5ff6f3eefab12a1b6765ca2116b&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }
}
