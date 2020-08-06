package com.yhc.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhc.example.bean.Response;
import com.yhc.example.constant.UserMsgContants;
import com.yhc.example.domain.entity.MatDic;
import com.yhc.example.service.IMatDicService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/mat/dic")
public class MatDicController {

    @Autowired
    private IMatDicService matDicService;

    @Autowired
    private Response response;

    @GetMapping("/list")
    @RequiresPermissions("mat:dic:list")
    public Response list() {
       List<MatDic> matDicList = matDicService.list();
        return response.success("查询成功", matDicList);
    }

    @GetMapping("/get")
    @RequiresPermissions("mat:dic:get")
    public Response get(String matCode) {
        if(matCode==null || matCode.equals("")){
            return response.failure("参数不正确");
        }
        QueryWrapper<MatDic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("f_mat_code",matCode);
        MatDic matDic = matDicService.getOne(queryWrapper);
        return response.success(UserMsgContants.SUCCESS, matDic);
    }
}
