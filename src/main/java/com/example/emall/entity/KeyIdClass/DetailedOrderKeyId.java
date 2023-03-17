package com.example.emall.entity.KeyIdClass;

import lombok.Data;

import java.io.Serializable;

@Data
public class DetailedOrderKeyId implements Serializable {
    private String uid;
    private int SKUId;

}
