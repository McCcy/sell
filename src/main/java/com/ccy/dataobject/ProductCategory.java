package com.ccy.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * Created by ccy on 2017/9/13.
 * product_category
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    /** 类目id. */
//    @Id
//    @GeneratedValue
//    private Integer category_id;
    /** 类目名字. */
//    private String category_name;
    /** 类目编号. */
//    private Integer category_type;
    /** 创建时间. */
//    private Date create_time;
    /** 更新时间. */
//    private Date update_time;

    public ProductCategory() {

    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
