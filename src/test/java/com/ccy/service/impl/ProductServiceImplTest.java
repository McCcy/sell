package com.ccy.service.impl;

import com.ccy.dataobject.ProductInfo;
import com.ccy.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ccy on 2017/9/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() throws Exception {
        ProductInfo result =productService.findOne("123456");
        Assert.assertEquals("123456",result.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest =new PageRequest(0,2);
        Page<ProductInfo> productInfoPage =productService.findAll(pageRequest);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotNull(productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("燕窝粥");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(200);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale() {
        ProductInfo result = productService.onSale("123458");
        Assert.assertEquals(ProductStatusEnum.UP, result.getProductStatusEnum());
    }

    @Test
    public void offSale() {
        ProductInfo result = productService.offSale("123458");
        Assert.assertEquals(ProductStatusEnum.DOWN, result.getProductStatusEnum());
    }
}