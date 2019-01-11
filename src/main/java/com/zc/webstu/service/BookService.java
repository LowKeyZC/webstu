package com.zc.webstu.service;

import com.zc.webstu.bean.Book;
import com.zc.webstu.dao.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;

    public List<Book> getAllBook() {
        return bookMapper.getAllBook();
    }

    public Book selectBookById(String bookId){
        return bookMapper.selectBookById(bookId);
    }

    public void insertBook(Book book) {
        String bookId = UUID.randomUUID().toString().replaceAll("-", "");
        book.setBookId(bookId);
        bookMapper.insertBook(book);
    }

    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    public void delBookById(String bookId) {
        bookMapper.delBookById(bookId);
    }
}
