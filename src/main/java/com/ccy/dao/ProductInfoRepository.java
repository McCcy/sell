package com.ccy.dao;

import com.ccy.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ccy on 2017/9/23.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatusIn(Integer productstatus);
}
