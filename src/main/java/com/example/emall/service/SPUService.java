package com.example.emall.service;

import com.example.emall.dao.SKURepository;
import com.example.emall.dao.SPURepository;
import com.example.emall.entity.SKU;
import com.example.emall.entity.SPU;
import com.example.emall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class SPUService {

    @Autowired
    private SPURepository spuRepository;

    @Autowired
    private SKURepository skuRepository;

    /**
     * 添加新spu
     * 添加新展品
     *
     * @param SPUId    展品id
     * @param sortName 类别
     * @param SPUName  展品名称
     * @param SPUImage 展品图片
     * @return 返回结果
     */
    public Result addNewSPU(int SPUId, String sortName, String SPUName, String SPUImage){
        SPU spu=spuRepository.findBySPUId(SPUId);
        if(spu!=null){
            return Result.fail("204","该id展品已存在");
        }
        SPU newSPU=new SPU(SPUId,sortName,SPUName,SPUImage);
        spuRepository.save(newSPU);
        return Result.nullSuccess();
    }

    /**
     * 删除展品
     * @param SPUId 展品id
     * @return      返回结果
     */
    public Result deleteSPU(int SPUId){
        SPU spu=spuRepository.findBySPUId(SPUId);
        if(spu==null){
            return Result.fail("204","展品不存在");
        }
        spuRepository.delete(spu);
        return Result.nullSuccess();
    }

    /**
     * 按类别查询展品
     * @param sortName  类别
     * @return          返回结果
     */
    public List<Result> getSPUBySortName(String sortName){
        List<Result> results=new ArrayList<>();
        List<SPU> SPUs=spuRepository.findBySortNameOrderByCreateTimeDesc(sortName);
        if( SPUs == null || SPUs.isEmpty() ){
            results.add(Result.fail("204","该分类下无展品"));
            return results;
        }
        for(SPU spu:SPUs){
            results.add(Result.success(spu));
        }
        return results;
    }

    /**
     * 模糊搜索商品名字
     *
     * @param SearchStr 搜索str
     * @return {@link List}<{@link Result}>
     */
    public List<Result> getSPUByName(String SearchStr)
    {
        List<Result> returnMessage = new ArrayList<>();
        List<SPU> returnList
                = spuRepository.findBySPUNameContaining(SearchStr);
        if(returnList == null || returnList.isEmpty())
        {
            returnMessage.add(Result.fail("204","没找到相关商品"));
        }
        else
        {
            returnMessage.add(Result.success(returnList));
        }
        return returnMessage;
    }

    /**
     * 得到sku
     *
     * @param SPUId spuid
     * @return {@link List}<{@link Result}>
     */
    public List<Result> getSKU(int SPUId)
    {
        List<Result> returnMessage = new ArrayList<>();
        List<SKU> returnList = skuRepository.findBySPUId(SPUId);
        if(returnList == null || returnList.isEmpty())
        {
            returnMessage.add(Result.fail("204","没找到相关产品"));
        }
        else
        {
            if(returnList == null || returnList.isEmpty())
            {
                returnMessage.add(Result.fail("204","没找到相关产品"));
            }
            else
            {
                returnMessage.add(Result.success(returnList));
            }
        }
        return returnMessage;
    }


}
