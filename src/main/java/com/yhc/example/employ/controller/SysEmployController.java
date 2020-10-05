package com.yhc.example.employ.controller;


import com.alibaba.fastjson.JSONObject;
import com.yhc.example.bean.AjaxResult;
import com.yhc.example.bean.BeanEmptyUtil;
import com.yhc.example.bean.TableDataInfo;
import com.yhc.example.constant.SystemConstants;
import com.yhc.example.constant.UserMsgContants;
import com.yhc.example.employ.domain.SysEmploy;
import com.yhc.example.employ.domain.SysEmployCount;
import com.yhc.example.employ.service.ISysEmployService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;


/**
 * sys_employ
 *
 * @author yhc 2020-09-26
 */
@Controller
@RequestMapping("/employ")
public class SysEmployController {

    @Autowired
    private ISysEmployService sysEmployService;

    /**
     * 列表
     * @return
     */
    @GetMapping("/employ-list")
    public String list() {
        return "pages/employ/employ-list";
    }



    /**
     * 新增
     * @return
     */
    @GetMapping("/employ-insert")
    public String insert() {
        return "pages/employ/employ-insert";
    }

    /**
     * 修改
     * @return
     */
    @GetMapping("/employ-update")
    public String edit() {
        return "pages/employ/employ-update";
    }


    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(SysEmploy sysEmploy) {
        if(sysEmploy.getStatus() == null){
            sysEmploy.setStatus("1");
        }
        if (sysEmploy.getId() != null) {
            SysEmploy sysEmploy1 = sysEmployService.getOne(new QueryWrapper<SysEmploy>().eq("id", sysEmploy.getId()));
            if (sysEmploy1 != null) {
                sysEmployService.updateById(sysEmploy);
                return AjaxResult.success();
            }
        }else{
            boolean flag = sysEmployService.save(sysEmploy);
            if(flag){
                return AjaxResult.success();
            }
        }

        return AjaxResult.error();
    }

    /**
     * 删除
     */
    @PutMapping("/delete")
    @ResponseBody
    public AjaxResult userDel(@RequestBody String ids) {

        if(ids !=null && !ids.isEmpty()){
            String [] idArr = ids.split(",");
            List<Integer> userList = new ArrayList<>();
            for(String id:idArr){
                userList.add(Integer.parseInt(id));
            }
            boolean flag= sysEmployService.removeByIds(userList);
            if(!flag){
                return AjaxResult.error(UserMsgContants.ERROR);
            }
        }

        return AjaxResult.success();
    }

    /**
     * 查询
     */
    @GetMapping("/find")
    @ResponseBody
    public AjaxResult find(int id) {
        SysEmploy sysEmploy = sysEmployService.getOne(new QueryWrapper<SysEmploy>().eq("id", id));
        if (sysEmploy != null) {
            return AjaxResult.success(sysEmploy);
        } else {
            return AjaxResult.error("没有找到该对象");
        }
    }

    /**
     * 分页查询
     */
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(
            @RequestParam(required = false, defaultValue = "0") int pageNo,
            @RequestParam(required = false, defaultValue = "10") int pageSize, SysEmploy sysEmploy) {
        try {
            BeanEmptyUtil.setNullValue(sysEmploy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        QueryWrapper<SysEmploy> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(sysEmploy);
        IPage<SysEmploy> page = new Page<>(pageNo, pageSize);
        page = sysEmployService.page(page, queryWrapper);
        TableDataInfo tableDataInfo = new TableDataInfo();
        tableDataInfo.setCount(page.getTotal());
        tableDataInfo.setCode(SystemConstants.SUCCESS_CODE);
        tableDataInfo.setData(page.getRecords());
        //返回结果
        return tableDataInfo;
    }

    @GetMapping("/count")
    @ResponseBody
    public AjaxResult count() {
        List<SysEmployCount> sysEmployCounts = sysEmployService.selectSysEmployCount();
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        JSONObject jsObject = new JSONObject();

        if(!sysEmployCounts.isEmpty()){
            for(int i=sysEmployCounts.size()-1;i>=0;i--){
                stringList.add(sysEmployCounts.get(i).getEmployTime());
                integerList.add(sysEmployCounts.get(i).getEmployNum());
            }
        }
        jsObject.put("stringList",stringList);
        jsObject.put("integerList",integerList);
        return AjaxResult.success(jsObject);
    }

}
