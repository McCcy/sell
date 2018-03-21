package com.ccy.enums;

import lombok.Getter;

/**
 * Created by ccy on 2017/9/24.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    New(0,"新订单"),
    FINISH(1,"完结订单"),
    CANCEL(2,"取消订单")
    ;
    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
