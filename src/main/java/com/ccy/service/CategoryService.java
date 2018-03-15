package com.ccy.service;

import com.ccy.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by ccy on 2017/9/22.
 */

public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryIdList);
    ProductCategory save(ProductCategory productCategory);
}
