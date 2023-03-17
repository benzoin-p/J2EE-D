package com.example.emall.entity;

import io.swagger.annotations.Api;
import javax.persistence.*;
import lombok.Data;

@Entity
@Api(tags = "用户")
@Data
@Table(name = "User")
public class User {

    @Id
    @Column(name = "uid",nullable = false)
    private String uid;

    @Column(name = "password",nullable = false,length = 20)
    private String password;

    @Column(name="userName",nullable = false,length = 20)
    private String userName;

    /**
     * 用户
     * @param uid       用户id
     * @param password  密码
     * @param userName  用户名
     */
    public User(String uid, String password, String userName) {
        this.uid = uid;
        this.password = password;
        this.userName = userName;
    }

    public User(){}

}
