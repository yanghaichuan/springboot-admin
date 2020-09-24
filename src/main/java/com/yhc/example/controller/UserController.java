package com.yhc.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhc.example.bean.AjaxResult;
import com.yhc.example.bean.TableDataInfo;
import com.yhc.example.constant.UserConstants;
import com.yhc.example.constant.UserMsgContants;
import com.yhc.example.domain.entity.User;
import com.yhc.example.service.IUserService;
import com.yhc.example.util.MD5Utils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


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


    /**
     * 用户列表
     * @return
     */
    @GetMapping("/user-list")
    public String list() {
        return "pages/user/user-list";
    }


    /**
     * 用户新增
     * @return
     */
    @GetMapping("/user-insert")
    public String add() {
        return "pages/user/user-insert";
    }

    /**
     * 用户查询.
     *
     * @return
     */
    @GetMapping("/userList")
    @ResponseBody
    public TableDataInfo listUsers(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        IPage<User> page = new Page<>(pageNo, pageSize);
        page = iUserService.page(page,queryWrapper);
        TableDataInfo tableDataInfo = new TableDataInfo();
        tableDataInfo.setCount(page.getTotal());
        tableDataInfo.setCode(0);
        tableDataInfo.setData(page.getRecords());
        return tableDataInfo;
    }

    /**
     * 用户添加;
     *
     * @return
     */
    @PostMapping("/userAdd")
    @RequiresPermissions("user:add")//权限管理;
    @ResponseBody
    public AjaxResult userInfoAdd(@RequestBody User user) {
        if (user.getUserName().isEmpty()) {
            return AjaxResult.error(UserMsgContants.USER_NEME_ISEMPTY);
        }
        if (user.getPassword().isEmpty()) {
            return AjaxResult.error(UserMsgContants.USER_PWD_ISEMPTY);
        }
        user.setState(Integer.parseInt(UserConstants.NORMAL));
        String pwd = MD5Utils.encrypt(user.getUserName(), user.getPassword());
        user.setPassword(pwd);
        user.setSalt(MD5Utils.SALT);
        user.setCreateTime(new Date());
        boolean flag = iUserService.save(user);
        if(!flag){
            return AjaxResult.error(UserMsgContants.ERROR);
        }
        return AjaxResult.success(UserMsgContants.SUCCESS);
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
