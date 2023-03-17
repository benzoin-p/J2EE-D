package com.example.emall.service;

import com.example.emall.dao.DeliveryAddressRepository;
import com.example.emall.entity.DeliveryAddress;
import com.example.emall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    /**
     * 添加地址
     * @param uid           用户id
     * @param address       地址
     * @param consignee     收件人
     * @param phoneNumber   电话号码
     * @param remarks       备注
     * @return              返回结果
     */
    public Result addAddress(String uid,String address,String consignee,String phoneNumber,String remarks){
        DeliveryAddress deliveryAddress=deliveryAddressRepository.findByUidAndAddress(uid,address);
        if(deliveryAddress != null){
            return Result.fail("400","地址已存在");
        }
        DeliveryAddress newAddress=new DeliveryAddress(uid,address,consignee,phoneNumber,remarks);
        deliveryAddressRepository.save(newAddress);
        return Result.nullSuccess();
    }

    /**
     * 删除地址
     * @param uid       用户id
     * @param address   地址
     * @return          返回结果
     */
    public Result deleteAddress(String uid,String address){
        DeliveryAddress deliveryAddress=deliveryAddressRepository.findByUidAndAddress(uid,address);
        if(deliveryAddress == null){
            return Result.fail("204","地址不存在");
        }
        deliveryAddressRepository.delete(deliveryAddress);
        return Result.nullSuccess();
    }

    /**
     * 获取所有地址
     * @param uid   用户id
     * @return      返回结果
     */
    public List<Result> getAddresses(String uid){
        List<Result> results=new ArrayList<>();
        List<DeliveryAddress> addresses=deliveryAddressRepository.findByUid(uid);
        if( addresses == null || addresses.isEmpty() ){
            results.add(Result.fail("204","地址列表为空"));
            return results;
        }
        for(DeliveryAddress deliveryAddress:addresses){
            results.add(Result.success(deliveryAddress));
        }
        return results;
    }

}
