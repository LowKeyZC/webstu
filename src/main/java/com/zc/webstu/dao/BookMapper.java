package com.zc.webstu.dao;

import com.zc.webstu.bean.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    List<Book> getAllBook();

    Book selectBookById(String bookId);

    void updateBook(Book book);

    void insertBook(Book book);

    void delBookById(String bookId);
}
