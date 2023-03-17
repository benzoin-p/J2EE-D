package com.example.emall.controller;

import com.example.emall.result.Result;
import com.example.emall.service.SPUService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@ResponseBody
@Controller
@Api(tags = "SPU控制器")
@RequestMapping(value = "/SPU")
@CrossOrigin
public class SPUController {

    @Autowired
    private SPUService spuService;

    /**
     * 添加新spu
     *
     * @param SPUId    spuid
     * @param sortName 类名字
     * @param SPUName  spuname
     * @param SPUImage spuimage
     * @return {@link Result}
     */
    @PostMapping(value = "/addNewSPU")
    public Result addNewSPU(@RequestParam int SPUId,
                            @RequestParam String sortName,
                            @RequestParam String SPUName,
                            @RequestParam String SPUImage)
    {
        return spuService.addNewSPU(SPUId, sortName, SPUName, SPUImage);
    }

    /**
     * 删除spu
     *
     * @param SPUId spuid
     * @return {@link Result}
     */
    @GetMapping(value = "/deleteSPU")
    public Result deleteSPU(@RequestParam int SPUId)
    {
        return spuService.deleteSPU(SPUId);
    }

    /**
     * 得到spuby类型名称
     *
     * @param sortName 类名字
     * @return {@link List}<{@link Result}>
     */
    @GetMapping(value = "/getSPUBySortName")
    public List<Result> getSPUBySortName(@RequestParam String sortName)
    {
        return spuService.getSPUBySortName(sortName);
    }

    /**
     * 得到spuby spuname
     *
     * @param spuName spu名字
     * @return {@link List}<{@link Result}>
     */
    @GetMapping(value = "/getSPUBySPUName")
    public List<Result> getSPUBySPUName(@RequestParam String spuName)
    {
        return spuService.getSPUByName(spuName);
    }

    @GetMapping(value = "/getSKU")
    public List<Result> getSKU(@RequestParam int spuId)
    {
        return spuService.getSKU(spuId);
    }



}
