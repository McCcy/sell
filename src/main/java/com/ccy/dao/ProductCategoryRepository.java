package com.ccy.dao;

import com.ccy.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Created by ccy on 2017/9/13.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
