package com.example.emall.entity;

import com.example.emall.entity.KeyIdClass.SKUKeyId;
import io.swagger.annotations.Api;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Api(tags = "库存量单位（实体产品）")
@Data
@Table(name = "SKU")
@IdClass(SKUKeyId.class)
public class SKU {

    @Id
    @Column(name = "SKUId",nullable = false)
    private int SKUId;

    @Id
    @Column(name = "SPUId",nullable = false)
    private int SPUId;

    @Column(name = "SKUName",nullable = false,length = 20)
    private String SKUName;

    @Column(name = "SKUPrice",nullable = false)
    private double SKUPrice;

    @Column(name = "SKUQuantity",nullable = false)
    @ColumnDefault("0")
    private int SKUQuantity;

    @Column(name = "SKUImage",nullable = false)
    private String SKUImage;

    @Column(name = "description",nullable = false)
    private String description;

    /**
     * sku
     * 实体产品
     *
     * @param SKUId       实体产品id
     * @param SKUName     实体产品名称
     * @param SKUPrice    实体产品价格
     * @param SKUQuantity 实体产品数量
     * @param SKUImage    实体产品图片
     * @param description 实体产品描述
     * @param SPUId       spuid
     */
    public SKU(int SKUId, int SPUId,String SKUName, double SKUPrice, int SKUQuantity, String SKUImage, String description) {
        this.SKUId = SKUId;
        this.SPUId = SPUId;
        this.SKUName = SKUName;
        this.SKUPrice = SKUPrice;
        this.SKUQuantity = SKUQuantity;
        this.SKUImage = SKUImage;
        this.description = description;
    }

    public SKU(){}

}
