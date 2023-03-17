package com.example.emall.controller;

import com.example.emall.result.Result;
import com.example.emall.service.MerchantWarehouseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Controller
@Api(tags = "库存控制器")
@RequestMapping(value = "/merchantWarehouse")
@CrossOrigin
public class MerchantWarehouseController {

    @Autowired
    private MerchantWarehouseService merchantWarehouseService;

    /**
     * 获取存储
     *
     * @param SKUId skuid
     * @return {@link Result}
     */
    @GetMapping("/getStorage")
    public Result getStorage(@RequestParam int SKUId)
    {
        return Result.success(merchantWarehouseService.getStorage(SKUId));
    }

    /**
     * 检查存储
     *
     * @param SKUId skuid
     * @param num   全国矿工工会
     * @return {@link Result}
     */
    @GetMapping("/checkStorage")
    public Result checkStorage(@RequestParam int SKUId,
                               @RequestParam int num)
    {
        int flag=merchantWarehouseService.checkStorage(SKUId, num);
        if(flag==-1)
        {
            return Result.fail("204","商品不存在");
        }
        else
        {
            return Result.success(merchantWarehouseService.checkStorage(SKUId,num));
        }
    }

    /**
     * 减少存储
     *
     * @param SKUId skuid
     * @param num   全国矿工工会
     * @return {@link Result}
     */
    @PostMapping("/reduceStorage")
    public Result reduceStorage(@RequestParam int SKUId,
                                @RequestParam int num)
    {
        return merchantWarehouseService.reduceStorage(SKUId, num);
    }

    /**
     * 添加存储
     *
     * @param SKUId skuid
     * @param num   全国矿工工会
     * @return {@link Result}
     */
    @PostMapping("/addStorage")
    public Result addStorage(@RequestParam int SKUId,
                             @RequestParam int num)
    {
        return merchantWarehouseService.addStorage(SKUId, num);
    }

}
