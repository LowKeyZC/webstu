package com.zc.webstu.service;

import com.zc.webstu.bean.UserBookStatus;
import com.zc.webstu.dao.UserBookStatusMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserBookStatusService {

    @Resource
    private UserBookStatusMapper ubStatusMapper;

    public UserBookStatus selectUMSByUidMVid(String userId, String BookId){
        return ubStatusMapper.selectUBSByUidMVid(userId, BookId);
    }

    public void insertUserBookStatus(UserBookStatus status) {
        ubStatusMapper.insertUBS(status);
    }
}
