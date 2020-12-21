package com.yhc.example.system.controller;

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
        return "pages/login";
    }

    @GetMapping("/setting")
    public String setting(){
        return "pages/system/setting";
    }

    /**
     * 基本信息
     * @return
     */
    @GetMapping("/userInfo")
    public String userInfo() {
        return "pages/user/user-info";
    }
}
