package com.example.emall.dao;

import com.example.emall.entity.KeyIdClass.SKUKeyId;
import com.example.emall.entity.SKU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SKURepository extends JpaRepository<SKU, SKUKeyId> {

    //根据实体产品id查询产品信息
    SKU findBySKUId(int SKUId);

    List<SKU> findBySPUId(int SPUId);

    //根据实体产品名称模糊查询产品信息
    List<SKU> findBySKUNameContaining(String SKUName);

}
