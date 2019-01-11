package com.zc.webstu.service;

import com.zc.webstu.bean.User;
import com.zc.webstu.common.Result;
import com.zc.webstu.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public Result loginUser(User user, String userPwd) {

        if (null == user) {
            return Result.NOUSER;
        }

        if (!user.getUserPwd().equals(userPwd)) {
            return Result.WRONGPWD;
        }

        return Result.SUCCESS;
    }

    public User selectUserById(String userId) {
        return userMapper.selectUserById(userId);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
