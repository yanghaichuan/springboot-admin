package com.yhc.example.controller;


import com.yhc.example.bean.Response;
import com.yhc.example.constant.UserConstants;
import com.yhc.example.constant.UserMsgContants;
import com.yhc.example.domain.entity.User;
import com.yhc.example.service.IUserService;
import com.yhc.example.util.MD5Utils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @since 2019-06-28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private Response response;

    /**
     * 用户列表
     * @return
     */
    @GetMapping("/list")
    public String list() {
        return "/user/list";
    }

    /**
     * 用户查询.
     *
     * @return
     */
    @GetMapping("/userList")
    @RequiresPermissions("user:view")//权限管理;
    @ResponseBody
    public Response listUsers() {
        List<User> users = iUserService.listUsers();
        return response.success("查询成功！", users);
    }

    /**
     * 用户添加;
     *
     * @return
     */
    @PostMapping("/userAdd")
    @RequiresPermissions("user:add")//权限管理;
    @ResponseBody
    public Response userInfoAdd(@RequestBody User user) {
        if (user.getUserName().isEmpty()) {
            return response.failure(UserMsgContants.USER_NEME_ISEMPTY);
        }
        if (user.getPassword().isEmpty()) {
            return response.failure(UserMsgContants.USER_PWD_ISEMPTY);
        }
        user.setState(Integer.parseInt(UserConstants.NORMAL));
        String pwd = MD5Utils.encrypt(user.getUserName(), user.getPassword());
        user.setPassword(pwd);
        user.setSalt(MD5Utils.SALT);
        user.setCreateTime(new Date());
        boolean flag = iUserService.save(user);
        if(!flag){
            return response.failure(UserMsgContants.ERROR);
        }
        return response.success(UserMsgContants.SUCCESS);
    }

    /**
     * 用户删除;
     *
     * @return
     */
    @DeleteMapping("/userDel")
    @RequiresPermissions("user:del")//权限管理;
    @ResponseBody
    public String userDel() {
        return "userDel";
    }

}
