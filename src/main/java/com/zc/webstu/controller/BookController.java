package com.zc.webstu.controller;

import com.zc.webstu.Resp.BookResp;
import com.zc.webstu.bean.Book;
import com.zc.webstu.bean.User;
import com.zc.webstu.bean.UserBookStatus;
import com.zc.webstu.common.Constant;
import com.zc.webstu.common.Result;
import com.zc.webstu.service.BookService;
import com.zc.webstu.service.UserBookStatusService;
import com.zc.webstu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserBookStatusService ubStatusService;

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public List<BookResp> listBook(HttpSession session) {
        List<BookResp> resps = new ArrayList<>();

        List<Book> books = bookService.getAllBook();

        String userId = session.getAttribute("userId").toString();
        User user = userService.selectUserById(userId);

        boolean checkStatus = user.getRoleId().equals(Constant.CONSUMER);

        for (Book book : books) {
            BookResp bookResp = new BookResp();
            bookResp.setBookId(book.getBookId());
            bookResp.setBookName(book.getBookName());
            bookResp.setValue(book.getValue());

            if (checkStatus) {
                UserBookStatus umStatus = ubStatusService.selectUMSByUidMVid(userId, book.getBookId());
                if (null != umStatus) {
                    bookResp.setStatus(Constant.HASBUY);
                } else {
                    bookResp.setStatus(Constant.NOBUY);
                }
            } else {
                bookResp.setBookContent(book.getBookContent());
            }

            resps.add(bookResp);
        }

        return resps;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addBook() {
        return "add_book";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String addBook(Book book) {
        String bookId = UUID.randomUUID().toString().replaceAll("-", "");
        book.setBookId(bookId);

        bookService.insertBook(book);
        return "mana_book";
    }

    @RequestMapping(value = "play", method = RequestMethod.POST)
    @ResponseBody
    public String playBook(String bookId) {
        Book book = bookService.selectBookById(bookId);
        return book.getBookContent();
    }

    @RequestMapping(value = "buy", method = RequestMethod.POST)
    @ResponseBody
    public String buyBook(HttpSession session,String bookId) {
        String userId = session.getAttribute("userId").toString();
        User user = userService.selectUserById(userId);
        Integer money = user.getHasMoney();

        Book book = bookService.selectBookById(bookId);

        if (money < book.getValue()) {
            return Result.NOMONEY.getCode();
        }

        user.setHasMoney(money- book.getValue());
        userService.updateUser(user);

        UserBookStatus ums = new UserBookStatus(userId,bookId);

        ubStatusService.insertUserBookStatus(ums);

        return Result.SUCCESS.getCode();
    }
}
