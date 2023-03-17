package com.example.emall.service;

import com.example.emall.dao.MerchantWarehouseRepository;
import com.example.emall.dao.ShoppingCartRepository;
import com.example.emall.entity.MerchantWarehouse;
import com.example.emall.entity.ShoppingCart;
import com.example.emall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private MerchantWarehouseRepository merchantWarehouseRepository;

    /**
     * 获取购物车内容
     * @param uid   用户id
     * @return      返回结果
     */
    public List<Result> getShoppingCart(String uid){
        List<Result> results=new ArrayList<>();
        List<ShoppingCart> carts=shoppingCartRepository.findByUid(uid);
        if(carts == null){
            results.add(Result.fail("204","购物车为空"));
            return results;
        }
        for (ShoppingCart shoppingCart:carts){
            results.add(Result.success(shoppingCart));
        }
        return results;
    }

    /**
     * 添加商品
     * @param uid   用户id
     * @param SKUId 商品id
     * @param num   数量
     * @return      返回结果
     */
    public Result addSKU(String uid,int SKUId,int num)
    {
        MerchantWarehouse merchantWarehouse=merchantWarehouseRepository.findBySKUId(SKUId);
        if(merchantWarehouse == null)
        {
            return Result.fail("204","商品不存在");
        }
        if(merchantWarehouse.getSKUStatus() == 0)
        {
            return Result.fail("409","商品未上架");
        }
        else if (merchantWarehouse.getSKUStatus() == 2)
        {
            return Result.fail("409","商品已售罄");
        }
        else
        {
            if(merchantWarehouse.getSKUQuantity() < num)
            {
                return Result.fail("204","商品库存不足");
            }
            else
            {
                merchantWarehouse.setSKUQuantity(merchantWarehouse.getSKUQuantity()-num);
                merchantWarehouseRepository.save(merchantWarehouse);
                ShoppingCart shoppingCart=shoppingCartRepository.findByUidAndSKUId(uid, SKUId);
                if(shoppingCart == null)
                {
                    ShoppingCart cart=new ShoppingCart(uid,SKUId,num);
                    shoppingCartRepository.save(cart);
                }
                else
                {
                    shoppingCart.setQuantity(shoppingCart.getQuantity()+num);
                    shoppingCartRepository.save(shoppingCart);
                }
                return Result.nullSuccess();
            }
        }
    }

    /**
     * 删去商品
     * @param uid   用户id
     * @param SKUId 商品id
     * @param num   减少的数量
     * @return      返回结果
     */
    public Result reduceSKU(String uid,int SKUId,int num)
    {
        ShoppingCart shoppingCart=shoppingCartRepository.findByUidAndSKUId(uid,SKUId);
        if(shoppingCart == null)
        {
            return Result.fail("204","购物车中无此商品");
        }
        if (shoppingCart.getQuantity() < num)
        {
            return Result.fail("204","购物车商品数量少于需要删去的数目");
        }
        else
        {
            shoppingCart.setQuantity(shoppingCart.getQuantity()-num);
            shoppingCartRepository.save(shoppingCart);
            if(shoppingCart.getQuantity() == 0)
            {
                shoppingCartRepository.delete(shoppingCart);
            }
            MerchantWarehouse merchantWarehouse=merchantWarehouseRepository.findBySKUId(SKUId);
            if(merchantWarehouse.getSKUStatus() == 2)
            {
                merchantWarehouse.setSKUStatus(0);
            }
            merchantWarehouse.setSKUQuantity(merchantWarehouse.getSKUQuantity()+num);
            merchantWarehouseRepository.save(merchantWarehouse);
            return Result.nullSuccess();
        }
    }

}
