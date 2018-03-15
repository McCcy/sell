package com.ccy.exception;

import com.ccy.enums.ResultEnum;

/**
 * Created by ccy on 2017/10/4.
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        //把参数传到父类的构造方法中
       super(resultEnum.getMessage());
       this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
