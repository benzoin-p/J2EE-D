package com.example.emall.dao;

import com.example.emall.entity.DetailedOrder;
import com.example.emall.entity.KeyIdClass.DetailedOrderKeyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailedOrderRepository extends JpaRepository<DetailedOrder, DetailedOrderKeyId> {

    //通过用户id和订单id查询订单详情
    List<DetailedOrder> findByUidAndOrderId(String uid,String orderId);

    //通过用户id查询该用户订单详情
    List<DetailedOrder> findByUidOrderByCreateTimeDesc(String id);

    //通过订单id查询订单详情
    DetailedOrder findByOrderId(String orderId);

}
