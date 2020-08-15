package com.yhc.example.controller;


import com.yhc.example.bean.Response;
import com.yhc.example.domain.entity.SysMenu;
import com.yhc.example.domain.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * sys_menu
 * @author 杨海传 2020-08-15
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Resource
    private Response response;

    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    public Object save(SysMenu sysMenu){
        SysMenu menu = sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().eq("menuId",sysMenu.getMenuId()));
        if(menu!=null){
            sysMenuMapper.updateById(sysMenu);
        }else{
            sysMenuMapper.insert(sysMenu);
        }
        return response.success(sysMenu);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Object delete(int id){
        SysMenu sysMenu = sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().eq("id",id));
        if(sysMenu!=null){
            return response.success(sysMenu);
        }else{
            return response.failure("没有找到该对象");
        }
    }

    /**
     * 查询
     */
    @PostMapping("/find")
    public Object find(int id){
        SysMenu sysMenu = sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().eq("id",id));
        if(sysMenu!=null){
            return response.success(sysMenu);
        }else{
            return response.failure("没有找到该对象");
        }
    }

    /**
     * 分页查询
     */
    @PostMapping("/list")
    public Object list(SysMenu sysMenu,
                       @RequestParam(required = false, defaultValue = "0") int pageNumber,
                       @RequestParam(required = false, defaultValue = "10") int pageSize) {
        //分页构造器
        Page<SysMenu> page = new Page<SysMenu>(pageNumber,pageSize);
        //条件构造器
        QueryWrapper<SysMenu> queryWrapperw = new QueryWrapper<SysMenu>(sysMenu);
        //执行分页
        IPage<SysMenu> pageList = sysMenuMapper.selectPage(page, queryWrapperw);
        //返回结果
        return response.success(pageList);
    }

}

