package com.example.emall.entity.KeyIdClass;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryAddressKeyId implements Serializable {
    private String uid;
    private String address;
}
