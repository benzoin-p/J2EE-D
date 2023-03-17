package com.example.emall.entity;

import com.example.emall.entity.KeyIdClass.DeliveryAddressKeyId;
import io.swagger.annotations.Api;
import javax.persistence.*;
import lombok.Data;

@Entity
@Api(tags = "交货地址")
@Data
@Table(name = "DeliveryAddress")
@IdClass(DeliveryAddressKeyId.class)
public class DeliveryAddress {

    @Id
    @Column(name = "uid",nullable = false)
    private String uid;

    @Id
    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "consignee",nullable = false,length = 20)
    private String consignee;

    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name = "remarks",nullable = false)
    private String remarks;

    /**
     * 交货地址
     * @param uid           用户id
     * @param address       地址
     * @param consignee     收货人
     * @param phoneNumber   电话号码
     * @param remarks       备注
     */
    public DeliveryAddress(String uid, String address, String consignee, String phoneNumber, String remarks) {
        this.uid = uid;
        this.address = address;
        this.consignee = consignee;
        this.phoneNumber = phoneNumber;
        this.remarks = remarks;
    }

    public DeliveryAddress(){}

}
