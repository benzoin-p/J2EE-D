package com.example.emall.entity.KeyIdClass;

import lombok.Data;

import java.io.Serializable;

@Data
public class SKUKeyId implements Serializable{
    private int SKUId;
    private int SPUId;
}
