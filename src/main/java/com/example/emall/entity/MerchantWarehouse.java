package com.example.emall.entity;

import io.swagger.annotations.Api;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Api(tags = "商品库存")
@Data
@Table(name = "MerchantWarehouse")
public class MerchantWarehouse {

    @Id
    @Column(name = "SKUId",nullable = false)
    private int SKUId;

    @Column(name = "SKUQuantity",nullable = false)
    private int SKUQuantity;

    //0表示未上架 1表示已上架 2表示售罄
    @Column(name = "SKUStatus",nullable = false)
    @ColumnDefault(value = "0")
    private int SKUStatus;

    /**
     * 商品库存
     * @param SKUId         实体产品id
     * @param SKUQuantity   实体产品数量
     * @param SKUStatus     状态（0-未上架 1-已上架 2-售罄）
     */
    public MerchantWarehouse(int SKUId, int SKUQuantity, int SKUStatus) {
        this.SKUId = SKUId;
        this.SKUQuantity = SKUQuantity;
        this.SKUStatus = SKUStatus;
    }

    public MerchantWarehouse(){}

}
