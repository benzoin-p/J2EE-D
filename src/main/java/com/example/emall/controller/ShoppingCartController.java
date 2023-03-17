package com.example.emall.controller;

import com.example.emall.result.Result;
import com.example.emall.service.ShoppingCartService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@Api(tags = "购物车控制器")
@RequestMapping(value = "/shoppingCart")
@CrossOrigin
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 得到购物车
     *
     * @param uid uid
     * @return {@link List}<{@link Result}>
     */
    @GetMapping("/getShoppingCart")
    public List<Result> getShoppingCart(@RequestParam String uid)
    {
        return shoppingCartService.getShoppingCart(uid);
    }

    /**
     * 添加sku
     *
     * @param uid   uid
     * @param SKUId skuid
     * @param num   全国矿工工会
     * @return {@link Result}
     */
    @PostMapping("/addSKU")
    public Result addSKU(@RequestParam String uid,
                         @RequestParam int SKUId,
                         @RequestParam int num)
    {
        return shoppingCartService.addSKU(uid, SKUId, num);
    }

    /**
     * 减少sku
     *
     * @param uid   uid
     * @param SKUId skuid
     * @param num   全国矿工工会
     * @return {@link Result}
     */
    @GetMapping("/reduceSKU")
    public Result reduceSKU(@RequestParam String uid,
                            @RequestParam int SKUId,
                            @RequestParam int num)
    {
        return shoppingCartService.reduceSKU(uid, SKUId, num);
    }

}
