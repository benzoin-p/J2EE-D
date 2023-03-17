package com.example.emall.service;

import com.example.emall.dao.MerchantWarehouseRepository;
import com.example.emall.entity.MerchantWarehouse;
import com.example.emall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantWarehouseService {

    @Autowired
    private MerchantWarehouseRepository merchantWarehouseRepository;

    /**
     * 查询库存
     * @param SKUId 实体商品id
     * @return      商品库存
     */
    public int getStorage(int SKUId){
        MerchantWarehouse merchantWarehouse=merchantWarehouseRepository.findBySKUId(SKUId);
        if(merchantWarehouse == null){
            return -1;
        }
        return merchantWarehouse.getSKUQuantity();
    }

    /**
     * 检查库存
     * @param SKUId 实体商品id
     * @param num   待比较数值
     * @return      返回结果（-1-商品不存在 0-库存不足 1-库存充足）
     */
    public int checkStorage(int SKUId,int num)
    {
        MerchantWarehouse merchantWarehouse=merchantWarehouseRepository.findBySKUId(SKUId);
        if(merchantWarehouse == null)
        {
            return -1;
        }
        int quantity=merchantWarehouse.getSKUQuantity();
        if(num > quantity)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    /**
     * 减少库存
     * @param SKUId 实体商品id
     * @param num   减少数目
     * @return      返回结果
     */
    public Result reduceStorage(int SKUId,int num)
    {
        MerchantWarehouse merchantWarehouse=merchantWarehouseRepository.findBySKUId(SKUId);
        if(merchantWarehouse == null)
        {
            return Result.fail("204","商品不存在");
        }
        int status=checkStorage(SKUId, num);
        if( status == -1 || status == 0 )
        {
            return Result.fail("204","库存不足，无法减少指定数目");
        }
        else
        {
            merchantWarehouse.setSKUQuantity(merchantWarehouse.getSKUQuantity()-num);
            if(merchantWarehouse.getSKUQuantity() <= 0)
            {
                merchantWarehouse.setSKUStatus(2);
            }
            else
            {
                merchantWarehouse.setSKUStatus(1);
            }
            return Result.inform("库存修改成功");
        }
    }

    /**
     * 添加库存
     * @param SKUId 实体商品id
     * @param num   增加数目
     * @return      返回结果
     */
    public Result addStorage(int SKUId,int num){
        return reduceStorage(SKUId,-num);
    }
}
