package com.zc.webstu.dao;

import com.zc.webstu.bean.UserBookStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookStatusMapper {

    UserBookStatus selectUBSByUidMVid(@Param("userId") String userId, @Param("bookId") String bookId);

    void insertUBS(UserBookStatus status);
}
