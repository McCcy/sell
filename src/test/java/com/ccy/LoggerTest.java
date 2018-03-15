package com.ccy;
import org.apache.commons.lang.StringUtils ;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.loader.custom.Return;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ccy on 2017/9/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    @Resource
//    private WebServiceContext wsContext;
    @Test
    public void test(){
        String name ="ccy";
        String password ="123";
        log.info("name: "+name+" password: "+password);
        log.info("name: {} , password: {}",name,password);
        log.error("我是error");
        log.warn("warn...");
    }
//    @Test
//    public void uuid(){
//        int minNum=32;
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        int i = (int)(minNum+Math.random()*(32-minNum+1));
//        uuid = uuid.substring(i-minNum, i);
//        int l =uuid.length();
//        System.out.println(uuid);
//        System.out.println(l);
//    }
//    @Test
//    public void test2(){
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        try {
//            System.out.println("=============我是访问IP："+getIpAddr(request)+"==================");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static String getIpAddr(HttpServletRequest request) throws Exception{
//        String ip = request.getHeader("X-Real-IP");
//        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
//            return ip;
//        }
//        ip = request.getHeader("X-Forwarded-For");
//        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
//            // 多次反向代理后会有多个IP值，第一个为真实IP。
//            int index = ip.indexOf(',');
//            if (index != -1) {
//                return ip.substring(0, index);
//            } else {
//                return ip;
//            }
//        } else {
//            return request.getRemoteAddr();
//        }
//    }
//
//    public static String getMD5(String message) {
//        String md5String = "";
//        try {
//            MessageDigest md5 = MessageDigest.getInstance("MD5");
//            byte[] inputByte = message.getBytes("utf-8");
//            byte[] buff = md5.digest(inputByte);
//            md5String = bytesToHex(buff);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return md5String;
//    }
//    private static String bytesToHex(byte[] bytes) {
//        StringBuffer md5StringBuffer = new StringBuffer();
//        int digital;
//        for (int i = 0; i < bytes.length; i++) {
//            digital = bytes[i];
//            if (digital < 0) {
//                digital = digital + 256;
//            }
//            if (digital < 16) {
//                md5StringBuffer.append("0");
//            }
//            md5StringBuffer.append(Integer.toHexString(digital));
//        }
//        return md5StringBuffer.toString();
//    }
    @Test
    public void Test3(){
        String a="庞保惠";
//        System.out.println(getMD5(a));
        System.out.println(a);
    }
}
