package com.ccy.enums;

import lombok.Getter;

/**
 * Created by ccy on 2017/9/24.
 */
@Getter
public enum ProductStatusEnum {
    Up(0,"在架商品"),
    Down(1,"下架商品")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
