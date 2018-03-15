package com.ccy.dao;

import com.ccy.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ccy on 2017/9/24.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
