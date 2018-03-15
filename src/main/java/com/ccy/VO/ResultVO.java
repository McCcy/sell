package com.ccy.VO;

import lombok.Data;

/**
 * http 请求返回的最外层对象
 * Created by ccy on 2017/9/24.
 */
@Data
public class ResultVO<T> {
    /** 错误码. */
    private Integer code;
    /** 提示信息. */
    private String msg;
    /** 具体内容. */
    private T data;
}
