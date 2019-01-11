package com.zc.webstu.bean;

import com.zc.webstu.common.Constant;
import com.zc.webstu.util.Md5Utils;

public class UserBookStatus {

    private String ubId;
    private String userId;
    private String bookId;
    private Integer status;

    public UserBookStatus(){}

    public UserBookStatus(String userId, String bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.ubId = Md5Utils.hash(userId + bookId);
        this.status = Constant.HASBUY;
    }

    public String getUbId() {
        return ubId;
    }

    public void setUbId(String ubId) {
        this.ubId = ubId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
