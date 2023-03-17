package com.example.emall.controller;

import com.example.emall.result.Result;
import com.example.emall.service.DeliveryAddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@Api(tags = "取件地址控制器")
@RequestMapping(value = "/deliveryAddress")
@CrossOrigin
public class DeliveryAddressController {

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    /**
     * 添加地址
     *
     * @param uid         uid
     * @param address     地址
     * @param consignee   收货人
     * @param phoneNumber 电话号码
     * @param remarks     讲话
     * @return {@link Result}
     */
    @PostMapping("/addAddress")
    public Result addAddress(@RequestParam String uid,
                             @RequestParam String address,
                             String consignee, String phoneNumber, String remarks)
    {
        return deliveryAddressService.addAddress(uid, address, consignee, phoneNumber, remarks);
    }

    /**
     * 删除地址
     *
     * @param uid     uid
     * @param address 地址
     * @return {@link Result}
     */
    @PostMapping("/deleteAddress")
    public Result deleteAddress(@RequestParam String uid,
                                @RequestParam String address)
    {
        return deliveryAddressService.deleteAddress(uid, address);
    }

    /**
     * 获得地址
     *
     * @param uid uid
     * @return {@link List}<{@link Result}>
     */
    @GetMapping("/getAddresses")
    public List<Result> getAddresses(@RequestParam String uid)
    {
        return deliveryAddressService.getAddresses(uid);
    }

}
