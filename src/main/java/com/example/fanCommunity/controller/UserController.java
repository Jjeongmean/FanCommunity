package com.example.fanCommunity.controller;

import com.example.fanCommunity.dto.User;
import com.example.fanCommunity.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/join")
    public String join(User user) {
        try {
            userService.signUp(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/";
    }


    @GetMapping(value = "/login")
    public String login() {
        return "user/login";
    }

    @PostMapping(value = "/login")
    public String loginUser(User user, Model model, HttpSession session) {
        //1. 사용자가 입력한 로그인 데이터와 DB에 저장된 데이터가 맞는지 비교
        try {
            User loginUser = userService.loginUser(user);

            //2. 데이터가 일치하면(로그인 성공시) index페이지로 이동
            if (loginUser != null) {
                //로그인 성공시 로그인한 사람의 name과 user_id를 세션에 저장
                // .setAttribute(키, 값) -> 세션에 값을 저장
                session.setAttribute("name", loginUser.getName());
                session.setAttribute("user_id", loginUser.getUserId());
                return "redirect:/";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "user/login";
    }


    @GetMapping(value = "/logout")
    public String logoutUser(HttpSession session) {
        session.removeAttribute("name");
        session.removeAttribute("user_id");

        return "redirect:/";
    }
  }
