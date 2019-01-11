package com.zc.webstu.controller;

import com.zc.webstu.bean.User;
import com.zc.webstu.common.Constant;
import com.zc.webstu.common.Result;
import com.zc.webstu.service.UserBookStatusService;
import com.zc.webstu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String loginUser(String userId, String userPwd, ModelMap mmap, HttpSession session) {

        User user = userService.selectUserById(userId);

        Result result = userService.loginUser(user, userPwd);

        if (result.equals(Result.SUCCESS)) {
            session.setAttribute("userId",user.getUserId());
            mmap.put("user", user);

            if (user.getRoleId().equals(Constant.CONSUMER)) {
                return "user_book";
            }
            if (user.getRoleId().equals(Constant.MANAGER)) {
                return "mana_book";
            }
        } else {
            mmap.put("msg", result.getMsg());
            return "error";
        }

        return null;
    }
}
