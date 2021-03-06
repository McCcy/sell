package com.ccy.util;

import java.util.Random;

/**
 * Created by ccy on 2017/10/4.
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式： 时间+随机数
     * @return
     * */
    public static synchronized String genUniqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
