package com.example.emall.service;

import com.example.emall.dao.MerchantWarehouseRepository;
import com.example.emall.dao.SKURepository;
import com.example.emall.entity.MerchantWarehouse;
import com.example.emall.entity.SKU;
import com.example.emall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SKUService {

    @Autowired
    private SKURepository skuRepository;

    @Autowired
    private MerchantWarehouseRepository merchantWarehouseRepository;

    /**
     * 添加新sku
     * 添加新产品
     *
     * @param SKUId       产品id
     * @param SKUName     产品名
     * @param SKUPrice    产品价格
     * @param SKUQuantity 产品数目
     * @param SKUImage    产品图片
     * @param description 产品描述
     * @param SPUId       spuid
     * @return 返回结果
     */
    public Result addNewSKU(int SKUId,int SPUId,String SKUName,double SKUPrice,int SKUQuantity,String SKUImage,String description){
        SKU sku=skuRepository.findBySKUId(SKUId);
        if(sku!=null){
            return Result.fail("204","商品已存在");
        }
        SKU newSKU=new SKU(SKUId,SPUId,SKUName,SKUPrice,SKUQuantity,SKUImage,description);
        skuRepository.save(newSKU);
        MerchantWarehouse merchantWarehouse=new MerchantWarehouse(SKUId,SKUQuantity,0);
        merchantWarehouseRepository.save(merchantWarehouse);
        return Result.nullSuccess();
    }

    /**
     * 删除产品
     * @param SKUId 产品id
     * @return      返回结果
     */
    public Result deleteSKU(int SKUId){
        SKU sku=skuRepository.findBySKUId(SKUId);
        if(sku==null){
            return Result.fail("204","商品不存在");
        }
        skuRepository.delete(sku);
        MerchantWarehouse merchantWarehouse=merchantWarehouseRepository.findBySKUId(SKUId);
        merchantWarehouse.setSKUQuantity(0);
        merchantWarehouse.setSKUStatus(0);
        return Result.nullSuccess();
    }

}
