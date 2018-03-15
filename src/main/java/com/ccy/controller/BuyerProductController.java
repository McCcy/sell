package com.ccy.controller;

import com.ccy.VO.ProductInfoVO;
import com.ccy.VO.ProductVO;
import com.ccy.VO.ResultVO;
import com.ccy.dataobject.ProductCategory;
import com.ccy.dataobject.ProductInfo;
import com.ccy.service.CategoryService;
import com.ccy.service.impl.ProductServiceImpl;
import com.ccy.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ccy on 2017/9/24.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){

        //1.查询所有上架的商品
        List<ProductInfo> productInfoList =productService.findUpAll();
        //2. 查询类目(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3. 数据的拼装
        List<ProductVO> productVOList =new ArrayList<>();
        for(ProductCategory p:productCategoryList){
            ProductVO productVO =new ProductVO();
            productVO.setCategoryType(p.getCategoryType());
            productVO.setCategoryName(p.getCategoryName());

            List<ProductInfoVO> productInfoVOList =new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(p.getCategoryType())){
                    ProductInfoVO productInfoVO =new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
