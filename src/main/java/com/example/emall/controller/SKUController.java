package com.example.emall.controller;

import com.example.emall.result.Result;
import com.example.emall.service.SKUService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Controller
@Api(tags = "SKU控制器")
@RequestMapping(value = "/SKU")
@CrossOrigin
public class SKUController {

    @Autowired
    private SKUService skuService;

    /**
     * 添加新sku
     *
     * @param SKUId       skuid
     * @param SKUName     skuname
     * @param SKUPrice    skuprice
     * @param SKUQuantity skuquantity
     * @param SKUImage    skuimage
     * @param description 描述
     * @param SPUId       spuid
     * @return {@link Result}
     */
    @PostMapping("/addNewSKU")
    public Result addNewSKU(@RequestParam int SKUId,
                            @RequestParam int SPUId,
                            @RequestParam String SKUName,
                            @RequestParam double SKUPrice,
                            int SKUQuantity, String SKUImage, String description)
    {
        return skuService.addNewSKU(SKUId, SPUId,SKUName, SKUPrice,
                SKUQuantity, SKUImage, description);
    }

    /**
     * 删除sku
     *
     * @param SKUId skuid
     * @return {@link Result}
     */
    @GetMapping("/deleteSKU")
    public Result deleteSKU(@RequestParam int SKUId)
    {
        return skuService.deleteSKU(SKUId);
    }

}
