package com.example.emall.dao;

import com.example.emall.entity.MerchantWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchantWarehouseRepository extends JpaRepository<MerchantWarehouse,Integer> {

    //根据实体产品id查询库存
    MerchantWarehouse findBySKUId(int SKUId);

    //根据实体产品状态查询库存
    List<MerchantWarehouse> findBySKUStatus(int SKUStatus);

}
