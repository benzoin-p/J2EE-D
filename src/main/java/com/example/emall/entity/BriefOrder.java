package com.example.emall.entity;

import com.example.emall.entity.KeyIdClass.BriefOrderKeyId;
import io.swagger.annotations.Api;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity
@Api(tags = "简要订单")
@Data
@Table(name = "BriefOrder")
@IdClass(BriefOrderKeyId.class)
public class BriefOrder {

    @Id
    @Column(name = "uid",nullable = false)
    private String uid;

    @Id
    @Column(name = "orderId",nullable = false)
    private String orderId;

    @Column(name = "createTime",nullable = false)
    private Timestamp createTime;

    @Column(name = "totalPrice",nullable = false)
    private double totalPrice;

    @Column(name = "address",nullable = false)
    private String address;

    //0为待付款，1为待发货，2为待收货，3为已收货
    @Column(name = "status",nullable = false)
    @ColumnDefault(value = "0")
    private int status;

    /**
     * 简要订单
     * @param uid           用户id
     * @param orderId       订单id
     * @param createTime    订单创建时间
     * @param totalPrice    总价格
     * @param address       地址
     * @param status        订单状态（0-待付款 1-待发货 2-待收货 3-已收货）
     */
    public BriefOrder(String uid, String orderId, Timestamp createTime, double totalPrice, String address, int status) {
        this.uid = uid;
        this.orderId = orderId;
        this.createTime = createTime;
        this.totalPrice = totalPrice;
        this.address = address;
        this.status = status;
    }

    public BriefOrder(){}

}
