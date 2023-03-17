package com.example.emall.entity;

import com.example.emall.entity.KeyIdClass.DetailedOrderKeyId;
import com.example.emall.entity.KeyIdClass.ShoppingCartKeyId;
import io.swagger.annotations.Api;
import javax.persistence.*;
import lombok.Data;

@Entity
@Api(tags = "购物车")
@Data
@Table(name = "ShoppingCart")
@IdClass(ShoppingCartKeyId.class)
public class ShoppingCart {

    @Id
    @Column(name = "uid",nullable = false)
    private String uid;

    @Id
    @Column(name = "SKUId",nullable = false)
    private int SKUId;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    /**
     * 购物车
     * @param uid       用户id
     * @param SKUId     实体产品id
     * @param quantity  实体产品数量
     */
    public ShoppingCart(String uid, int SKUId, int quantity) {
        this.uid = uid;
        this.SKUId = SKUId;
        this.quantity = quantity;
    }

    public ShoppingCart(){}

}
