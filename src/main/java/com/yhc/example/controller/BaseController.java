package com.yhc.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IDEA2018.3
 * author:杨海传
 * Date:2020-08-06 21:09
 */
@Slf4j
@Controller
public class BaseController {
    @GetMapping("/")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
