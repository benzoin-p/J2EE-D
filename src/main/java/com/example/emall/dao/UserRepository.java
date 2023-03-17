package com.example.emall.dao;

import com.example.emall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    //根据用户id查询用户信息
    User findByUid(String uid);

    //根据用户名模糊查询用户
    List<User> findByUserNameContaining(String userName);

}
