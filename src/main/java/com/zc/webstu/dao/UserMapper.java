package com.zc.webstu.dao;

import com.zc.webstu.bean.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 查询
     * @param userId
     */
    User selectUserById(String userId);

    /**
     * 更新
     * @param user
     */
    void updateUser(User user);
}
