package com.ccy.dto;

import lombok.Data;

/**
 * 购物车
 * Created by ccy on 2017/10/4.
 */
@Data
public class CartDTO {

    /** 商品id. */
    private String productId;
    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
