package com.ccy.util;

import com.ccy.enums.CodeEnum;

/**
 * Created by ccy
 * 2018/3/21 14:14
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
