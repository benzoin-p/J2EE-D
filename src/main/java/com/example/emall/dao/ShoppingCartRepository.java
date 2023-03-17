package com.example.emall.dao;

import com.example.emall.entity.KeyIdClass.ShoppingCartKeyId;
import com.example.emall.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartKeyId> {

    //根据用户id查询购物车内容
    List<ShoppingCart> findByUid(String uid);

    //根据用户id和商品id查询购物车中某商品数量
    ShoppingCart findByUidAndSKUId(String uid,int SKUId);

}
