package com.example.emall.dao;

import com.example.emall.entity.BriefOrder;
import com.example.emall.entity.KeyIdClass.BriefOrderKeyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BriefOrderRepository extends JpaRepository<BriefOrder, BriefOrderKeyId> {

    //通过用户id和订单id查找简要订单
    BriefOrder findByUidAndOrderId(String uid,String orderId);

    List<BriefOrder> findByUid(String uid);

    //通过用户id查找该用户的简要订单
    List<BriefOrder> findByUidOrderByCreateTimeDesc(String uid);

    //通过订单号查询简要订单
    List<BriefOrder> findByOrderId(String orderId);

    //通过订单状态查询简要订单
    List<BriefOrder> findByStatus(int status);

}
