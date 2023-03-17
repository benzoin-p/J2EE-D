package com.example.emall.dao;

import com.example.emall.entity.DeliveryAddress;
import com.example.emall.entity.KeyIdClass.DeliveryAddressKeyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, DeliveryAddressKeyId> {

    //通过用户id和地址查询交货地址信息
    DeliveryAddress findByUidAndAddress(String uid,String address);

    //通过用户id查询该用户交货地址信息
    List<DeliveryAddress> findByUid(String uid);

}
