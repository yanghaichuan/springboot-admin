package com.yhc.example.company.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhc.example.bean.AjaxResult;
import com.yhc.example.bean.BeanEmptyUtil;
import com.yhc.example.bean.TableDataInfo;
import com.yhc.example.company.domain.SysCompany;
import com.yhc.example.company.domain.SysCompanyRecruit;
import com.yhc.example.company.service.ISysCompanyMessageService;
import com.yhc.example.company.service.ISysCompanyRecruitService;
import com.yhc.example.company.service.ISysCompanyService;
import com.yhc.example.constant.SystemConstants;
import com.yhc.example.constant.UserMsgContants;
import com.yhc.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * sys_company
 *
 * @author yhc 2020-09-26
 */
@Controller
@RequestMapping("/company")
public class SysCompanyController {

    @Autowired
    private ISysCompanyService sysCompanyService;

    @Autowired
    private ISysCompanyRecruitService sysCompanyRecruitService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ISysCompanyMessageService sysCompanyMessageService;

    /**
     * 列表
     * @return
     */
    @GetMapping("/company-list")
    public String list() {
        return "pages/company/company-list";
    }



    /**
     * 新增
     * @return
     */
    @GetMapping("/company-insert")
    public String insert() {
        return "pages/company/company-insert";
    }

    /**
     * 修改
     * @return
     */
    @GetMapping("/company-update")
    public String edit() {
        return "pages/company/company-update";
    }


    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(SysCompany sysCompany) {
        sysCompany.setCreateTime(new Date());
        if(sysCompany.getStatus() == null){
            sysCompany.setStatus("1");
        }
        if (sysCompany.getId() != null) {
            SysCompany sysCompany1 = sysCompanyService.getOne(new QueryWrapper<SysCompany>().eq("id", sysCompany.getId()));
            if (sysCompany1 != null) {
                sysCompanyService.updateById(sysCompany);
                return AjaxResult.success();
            }
        }else{
            boolean flag = sysCompanyService.save(sysCompany);
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
            boolean flag= sysCompanyService.removeByIds(userList);
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
        SysCompany sysCompany = sysCompanyService.getOne(new QueryWrapper<SysCompany>().eq("id", id));
        if (sysCompany != null) {
            return AjaxResult.success(sysCompany);
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
            @RequestParam(required = false, defaultValue = "10") int pageSize, SysCompany sysCompany) {
        try {
            BeanEmptyUtil.setNullValue(sysCompany);
        } catch (Exception e) {
            e.printStackTrace();
        }
        QueryWrapper<SysCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(sysCompany);
        IPage<SysCompany> page = new Page<>(pageNo, pageSize);
        page = sysCompanyService.page(page, queryWrapper);
        TableDataInfo tableDataInfo = new TableDataInfo();
        tableDataInfo.setCount(page.getTotal());
        tableDataInfo.setCode(SystemConstants.SUCCESS_CODE);
        tableDataInfo.setData(page.getRecords());
        //返回结果
        return tableDataInfo;
    }


    /**
     * 查询
     */
    @GetMapping("/statNumber")
    @ResponseBody
    public AjaxResult statNumber() {
        JSONObject jsonObject = new JSONObject();
        QueryWrapper<SysCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",0);
        int count1 =sysCompanyService.count(queryWrapper);
        jsonObject.put("company",count1);

        QueryWrapper<SysCompanyRecruit> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("status",0);
        int count2 = sysCompanyRecruitService.count(queryWrapper1);
        jsonObject.put("recruit",count2);

        int count3 = iUserService.count();
        jsonObject.put("users",count3);

        int count4 = sysCompanyMessageService.count();
        jsonObject.put("message",count4);

        return AjaxResult.success(jsonObject);
    }

}
