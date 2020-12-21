package com.yhc.example.system.controller;

import com.yhc.example.common.bean.AjaxResult;
import com.yhc.example.common.bean.CacheUser;
import com.yhc.example.utils.MD5Utils;
import com.yhc.example.system.domain.entity.User;
import com.yhc.example.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ：yanghc
 * @date ：2020/7/03 17:11
 * @description：登录Controller
 */
@Slf4j
@Controller
public class LoginController {

    @Resource
    private IUserService iUserService;

    /**
     * create by: yanghc
     * description: 登录
     * create time: 2020/7/03 17:11
     *
     * @return 登录结果
     */
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult login(User user) {
        log.warn("进入登录.....");

        String userName = user.getUserName();
        String password = user.getPassword();

        if (StringUtils.isBlank(userName)) {
            return AjaxResult.error("用户名为空！");
        }

        if (StringUtils.isBlank(password)) {
            return AjaxResult.error("密码为空！");
        }

        String pwd = MD5Utils.encrypt(userName,password);
        System.out.println("加盐+次数构成的值:"+"================>"+pwd);
        CacheUser loginUser = iUserService.login(userName, password);
        // 登录成功返回用户信息
        return AjaxResult.success("登录成功！", loginUser);
    }

    /**
     * create by: yanghc
     * description: 登出
     * create time: 2020/7/03 14:22
     */
    @RequestMapping("/logout")
    public String logOut() {
        iUserService.logout();
        return "pages/login";
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * <br/>
     * create by: yanghc
     * <br/>
     * create time: 2020/7/03 13:11
     * @return
     */
    @RequestMapping("/un_auth")
    @ResponseBody
    public AjaxResult unAuth() {
        return AjaxResult.error(HttpStatus.UNAUTHORIZED.value(), "用户未登录！");
    }

    /**
     * 未授权，无权限，此处返回未授权状态信息由前端控制跳转页面
     * <br/>
     * create by: yanghc
     * <br/>
     * create time: 2020/7/03 17:11
     * @return
     */
    @RequestMapping("/unauthorized")
    @ResponseBody
    public AjaxResult unauthorized() {
        return AjaxResult.error(HttpStatus.FORBIDDEN.value(), "用户无权限！");
    }


    @RequestMapping("/heartDet")
    @ResponseBody
    public AjaxResult heartDet() {
        return AjaxResult.success("用户已登录");
    }
}
