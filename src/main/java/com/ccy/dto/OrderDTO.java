package com.ccy.dto;

import com.ccy.dataobject.OrderDetail;
import com.ccy.enums.OrderStatusEnum;
import com.ccy.enums.PayStatusEnum;
import com.ccy.util.EnumUtil;
import com.ccy.util.serializer.Date2lLongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by ccy on 2017/10/4.
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    List<OrderDetail> orderDetailList;
    /** 订单Id. */
    @Id
    private String orderId;
    /** 买家名字. */
    private String buyerName;
    /** 买家手机号. */
    private String buyerPhone;
    /** 买家地址. */
    private String buyerAddress;
    /** 买家微信Openid. */
    private String buyerOpenid;
    /** 订单总金额. */
    private BigDecimal orderAmount;
    /** 订单状态 默认为0 新下单. */
    private Integer orderStatus = OrderStatusEnum.New.getCode();
    /** 支付状态 默认为0 未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /** 创建时间. */
    @JsonSerialize(using = Date2lLongSerializer.class)
    private Date createTime;
    /** 更新时间. */
    @JsonSerialize(using = Date2lLongSerializer.class)
    private Date updateTime;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(payStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
