package com.ccy.service;

import com.ccy.dataobject.ProductInfo;
import com.ccy.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by ccy on 2017/9/24.
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //List<ProductInfo> findByProductStatus(Integer ProductStatus);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);
}
