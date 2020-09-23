package com.yhc.example.controller;

import com.yhc.example.bean.Response;
import com.yhc.example.constant.SystemConstants;
import com.yhc.example.domain.entity.SysMenu;
import com.yhc.example.domain.mapper.SysMenuMapper;
import com.yhc.example.domain.vo.MenuBean;
import com.yhc.example.domain.vo.TreeBean;
import com.yhc.example.util.BuildTree;
import com.yhc.example.util.TreeBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    public Response save(SysMenu sysMenu){
        SysMenu menu = sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().eq("menu_id",sysMenu.getMenuId()));
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
    public Response delete(int id){
        SysMenu sysMenu = sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().eq("menu_id",id));
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
    public Response find(int id){
        SysMenu sysMenu = sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().eq("menu_id",id));
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
    public Response list(SysMenu sysMenu,
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


    /**
     * 分页查询
     */
    @GetMapping("/select")
    public Response select(SysMenu sysMenu) throws Exception {
        //条件构造器
        QueryWrapper<SysMenu> queryWrapperw = new QueryWrapper<SysMenu>(sysMenu);
        //执行分页
        List<SysMenu> list = sysMenuMapper.selectList(queryWrapperw);

        List<MenuBean> treeBeans = new ArrayList<>();
        for(SysMenu menu:list){
            MenuBean treeBean = new MenuBean();
            treeBean.setId(menu.getMenuId());
            treeBean.setTitle(menu.getMenuName());
            treeBean.setHref(menu.getUrl());
            treeBean.setParentId(menu.getParentId());
            treeBean.setIcon(menu.getBadge());
            treeBean.setFontFamily(menu.getFontFamily());
            treeBeans.add(treeBean);
        }
        List<MenuBean> tree = TreeBeanUtils.getTree(treeBeans,"id");
        //返回结果
        return response.success(tree);
    }

}

