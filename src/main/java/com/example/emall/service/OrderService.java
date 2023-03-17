package com.example.emall.service;

import com.example.emall.dao.*;
import com.example.emall.entity.*;
import com.example.emall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private BriefOrderRepository briefOrderRepository;

    @Autowired
    private DetailedOrderRepository detailedOrderRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private SKURepository skuRepository;

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    /**
     * 添加新订单
     * @param uid   用户id
     * @return      返回结果
     */
    public Result addNewOrder(String uid){
        long curTime=System.currentTimeMillis();
        String orderId=String.valueOf(curTime);
        Timestamp createTime=new Timestamp(curTime);
        double totalPrice=0.0;
        List<ShoppingCart> carts=shoppingCartRepository.findByUid(uid);
        for(ShoppingCart cart:carts){
            int SKUId=cart.getSKUId();
            int quantity=cart.getQuantity();
            DetailedOrder detailedOrder=new DetailedOrder(uid,orderId,SKUId,quantity);
            detailedOrderRepository.save(detailedOrder);
            SKU sku=skuRepository.findBySKUId(SKUId);
            totalPrice+=sku.getSKUPrice()*quantity;
        }
        List<DeliveryAddress> addresses=deliveryAddressRepository.findByUid(uid);
        String address=addresses.get(0).getAddress();
        BriefOrder briefOrder=new BriefOrder(uid,orderId,createTime,totalPrice,address,0);
        briefOrderRepository.save(briefOrder);
        return Result.nullSuccess();
    }

    /**
     * 获取订单
     * @param uid       用户id
     * @param orderId   订单id
     * @return          返回结果
     */
    public List<Result> getOrder(String uid,String orderId){
        List<DetailedOrder> orders=detailedOrderRepository.findByUidAndOrderId(uid,orderId);
        List<Result> results=new ArrayList<>();
        if( orders == null || orders.isEmpty() ){
            results.add(Result.fail("204","无订单"));
            return results;
        }
        for (DetailedOrder detailedOrder:orders){
            results.add(Result.success(detailedOrder));
        }
        return results;
    }

    /**
     * 得到订单列表
     *
     * @param uid uid
     * @return {@link List}<{@link Result}>
     */
    public List<Result> getOrderList(String uid)
    {
        List<Result> returnMessage = new ArrayList<>();
        List<BriefOrder> briefOrderList = briefOrderRepository.findByUid(uid);
        if(briefOrderList == null || briefOrderList.isEmpty())
        {
            returnMessage.add(Result.fail("204","无订单"));
            return returnMessage;
        }
        for(BriefOrder briefOrder:briefOrderList)
        {
            returnMessage.add(Result.success(briefOrder));
        }
        return returnMessage;
    }

    /**
     * 更改订单状态
     * @param uid       用户id
     * @param orderId   订单id
     * @param status    状态
     * @return          返回结果
     */
    public Result changeOrderStatus(String uid,String orderId,int status){
        BriefOrder briefOrder=briefOrderRepository.findByUidAndOrderId(uid, orderId);
        if(briefOrder==null){
            return Result.fail("204","订单不存在");
        }
        briefOrder.setStatus(status);
        briefOrderRepository.save(briefOrder);
        return Result.nullSuccess();
    }

}
