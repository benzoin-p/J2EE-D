package com.example.emall.entity;

import io.swagger.annotations.Api;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Api(tags = "标准化产品单元（展品）")
@Data
@Table(name = "SPU")
public class SPU {

    @Id
    @Column(name = "SPUId",nullable = false)
    private int SPUId;

    @Column(name = "sortName",nullable = false,length = 20)
    private String sortName;

    @Column(name = "SPUName",nullable = false,length = 20)
    private String SPUName;

    @Column(name = "SPUImage",nullable = false)
    private String SPUImage;

    @CreationTimestamp
    @Column(name = "createTime",nullable = false)
    private Timestamp createTime;

    /**
     * spu
     * 展品
     *
     * @param SPUId    展品id
     * @param sortName 类别名称
     * @param SPUName  展品名称
     * @param SPUImage 展品图片
     */
    public SPU(int SPUId, String sortName, String SPUName, String SPUImage) {
        this.SPUId = SPUId;
        this.sortName = sortName;
        this.SPUName = SPUName;
        this.SPUImage = SPUImage;
    }

    public SPU(){}

}
