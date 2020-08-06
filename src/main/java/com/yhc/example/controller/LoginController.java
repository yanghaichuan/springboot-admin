package com.yhc.example.controller;

import com.yhc.example.bean.CacheUser;
import com.yhc.example.bean.Response;
import com.yhc.example.util.MD5Utils;
import com.yhc.example.domain.entity.User;
import com.yhc.example.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：yanghc
 * @date ：2020/7/03 17:11
 * @description：登录Controller
 */
@Slf4j
@RestController
public class LoginController {

    @Resource
    private IUserService iUserService;

    @Resource
    private Response response;

    /**
     * create by: yanghc
     * description: 登录
     * create time: 2020/7/03 17:11
     *
     * @return 登录结果
     */
    @PostMapping("/login")
    public Response login(User user) {
        log.warn("进入登录.....");

        String userName = user.getUserName();
        String password = user.getPassword();

        if (StringUtils.isBlank(userName)) {
            return response.failure("用户名为空！");
        }

        if (StringUtils.isBlank(password)) {
            return response.failure("密码为空！");
        }

        String pwd = MD5Utils.encrypt(userName,password);
        System.out.println("加盐+次数构成的值:"+"================>"+pwd);
        CacheUser loginUser = iUserService.login(userName, password);
        // 登录成功返回用户信息
        return response.success("登录成功！", loginUser);
    }

    /**
     * create by: yanghc
     * description: 登出
     * create time: 2020/7/03 14:22
     */
    @RequestMapping("/logout")
    public Response logOut() {
        iUserService.logout();
        return response.success("登出成功！");
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
    public Response unAuth() {
        return response.failure(HttpStatus.UNAUTHORIZED, "用户未登录！", null);
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
    public Response unauthorized() {
        return response.failure(HttpStatus.FORBIDDEN, "用户无权限！", null);
    }


    @RequestMapping("/heartDet")
    public Response heartDet() {
        return response.success("用户已登录");
    }
}
