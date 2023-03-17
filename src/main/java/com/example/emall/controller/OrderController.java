package com.example.emall.controller;

import com.example.emall.result.Result;
import com.example.emall.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@Api(tags = "订单控制器")
@RequestMapping(value = "/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 添加新订单
     *
     * @param uid uid
     * @return {@link Result}
     */
    @PostMapping("/addNewOrder")
    public Result addNewOrder(@RequestParam String uid)
    {
        return orderService.addNewOrder(uid);
    }

    /**
     * 得到订单
     *
     * @param uid     uid
     * @param orderId 订单id
     * @return {@link List}<{@link Result}>
     */
    @GetMapping("/getOrder")
    public List<Result> getOrder(@RequestParam String uid,
                                 @RequestParam String orderId)
    {
        return orderService.getOrder(uid,orderId);
    }

    /**
     * 改变订单状态
     *
     * @param uid     uid
     * @param orderId 订单id
     * @param status  状态
     * @return {@link Result}
     */
    @PostMapping("/changeOrderStatus")
    public Result changeOrderStatus(@RequestParam String uid,
                                    @RequestParam String orderId,
                                    @RequestParam int status)
    {
        return orderService.changeOrderStatus(uid, orderId, status);
    }

    /**
     * 得到订单列表
     *
     * @param uid uid
     * @return {@link List}<{@link Result}>
     */
    @GetMapping("/getOrderList")
    public List<Result> getOrderList(@RequestParam String uid)
    {
        return orderService.getOrderList(uid);
    }

}
