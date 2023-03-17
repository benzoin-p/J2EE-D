package com.example.emall.dao;

import com.example.emall.entity.SPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SPURepository extends JpaRepository<SPU,Integer> {

    //根据展品id查询展品信息
    SPU findBySPUId(int SPUId);

    //根据展品名称模糊查询展品信息
    List<SPU> findBySPUNameContaining(String SPUName);

    //根据展品分类查询展品信息
    List<SPU> findBySortNameOrderByCreateTimeDesc(String sortName);

}
