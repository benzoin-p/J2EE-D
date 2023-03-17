package com.example.emall.service;

import com.example.emall.dao.UserRepository;
import com.example.emall.entity.User;
import com.example.emall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 注册
     * @param uid       用户id
     * @param userName  用户名
     * @param password  密码
     * @return          返回结果
     */
    public Result register(String uid,String userName,String password){
        if( uid.isEmpty() || userName.isEmpty() || password.isEmpty() ){
            return Result.fail("204","请检查输入是否为空");
        }else if( userRepository.findByUid(uid) == null ){
            User user=new User(uid,password,userName);
            userRepository.save(user);
            return Result.nullSuccess();
        }else{
            return Result.fail("204","该id已被注册");
        }
    }

    /**
     * 登陆
     * @param uid       用户id
     * @param password  密码
     * @return          返回结果
     */
    public Result login(String uid,String password){
        User user=userRepository.findByUid(uid);
        if(user == null){
            return Result.fail("204","用户不存在");
        }
        if(user.getPassword().equals(password)){
            return Result.nullSuccess();
        }else{
            return Result.fail("204","密码错误");
        }
    }

    /**
     * 修改用户名
     * @param uid       用户id
     * @param newName   新用户名
     * @return          返回结果
     */
    public Result changeName(String uid,String newName){
        User user=userRepository.findByUid(uid);
        if(user == null){
            return Result.fail("204","用户不存在");
        }
        userRepository.delete(user);
        user.setUserName(newName);
        userRepository.save(user);
        return Result.nullSuccess();
    }

    /**
     * 确认旧密码
     * @param uid       用户id
     * @param password  旧密码
     * @return          返回结果
     */
    public Result confirmOldPassword(String uid,String password){
        User user=userRepository.findByUid(uid);
        if(user == null){
            return Result.fail("204","用户不存在");
        }
        if(user.getPassword().equals(password)){
            return Result.inform("旧密码正确");
        }else {
            return Result.inform("旧密码错误");
        }
    }

    /**
     * 修改密码
     * @param uid           用户id
     * @param newPassword   新密码
     * @return              返回结果
     */
    public Result changePassword(String uid,String newPassword){
        User user=userRepository.findByUid(uid);
        if(user == null){
            return Result.fail("204","用户不存在");
        }
        userRepository.delete(user);
        user.setPassword(newPassword);
        userRepository.save(user);
        return Result.nullSuccess();
    }

}
