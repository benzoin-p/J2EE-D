package com.example.emall.entity;

import com.example.emall.entity.KeyIdClass.DetailedOrderKeyId;
import io.swagger.annotations.Api;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Api(tags = "订单详情")
@Data
@Table(name = "DetailedOrder")
@IdClass(DetailedOrderKeyId.class)
public class DetailedOrder {

    @Id
    @Column(name = "uid",nullable = false)
    private String uid;

    @Column(name = "orderId",nullable = false)
    private String orderId;
    @Id
    @Column(name = "SKUId",nullable = false)
    private int SKUId;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    @CreationTimestamp
    @Column(name = "createTime",nullable = false)
    private Timestamp createTime;

    /**
     * 详细订单
     * 订单详情
     *
     * @param uid      用户id
     * @param orderId  订单id
     * @param SKUId    实体产品id
     * @param quantity 产品数量
     */
    public DetailedOrder(String uid, String orderId, int SKUId, int quantity) {
        this.uid = uid;
        this.orderId = orderId;
        this.SKUId = SKUId;
        this.quantity = quantity;
    }

    public DetailedOrder(){}

}
