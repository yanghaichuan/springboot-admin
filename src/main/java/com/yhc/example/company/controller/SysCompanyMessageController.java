package com.yhc.example.company.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhc.example.bean.AjaxResult;
import com.yhc.example.bean.BeanEmptyUtil;
import com.yhc.example.bean.TableDataInfo;
import com.yhc.example.company.domain.SysCompany;
import com.yhc.example.company.domain.SysCompanyMessage;
import com.yhc.example.company.service.ISysCompanyMessageService;
import com.yhc.example.company.service.ISysCompanyService;
import com.yhc.example.constant.SystemConstants;
import com.yhc.example.constant.UserMsgContants;
import com.yhc.example.domain.entity.User;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping("/company/message")
public class SysCompanyMessageController {

    @Autowired
    private ISysCompanyMessageService sysCompanyMessageService;

    /**
     * 列表
     * @return
     */
    @GetMapping("/message-list")
    public String list() {
        return "pages/company/message-list";
    }



    /**
     * 新增
     * @return
     */
    @GetMapping("/message-insert")
    public String insert() {
        return "pages/company/message-insert";
    }

    /**
     * 修改
     * @return
     */
    @GetMapping("/message-update")
    public String edit() {
        return "pages/company/message-update";
    }


    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(SysCompanyMessage sysCompanyMessage) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
            sysCompanyMessage.setCreateUser(user.getUserName());
        }
        sysCompanyMessage.setCreateTime(new Date());
        if (sysCompanyMessage.getId() != null) {
            sysCompanyMessage.setStatus("0");
            SysCompanyMessage sysCompanyMessage1 = sysCompanyMessageService.getOne(new QueryWrapper<SysCompanyMessage>().eq("id", sysCompanyMessage.getId()));
            if (sysCompanyMessage1 != null) {
                sysCompanyMessageService.updateById(sysCompanyMessage1);
                return AjaxResult.success();
            }
        }else{
            boolean flag = sysCompanyMessageService.save(sysCompanyMessage);
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
            boolean flag= sysCompanyMessageService.removeByIds(userList);
            if(!flag){
                return AjaxResult.error(UserMsgContants.ERROR);
            }
        }

        return AjaxResult.success();
    }

    /**
     * 查询
     */
    @PutMapping("/find")
    @ResponseBody
    public AjaxResult find(int id) {
        SysCompanyMessage sysCompanyMessage = sysCompanyMessageService.getOne(new QueryWrapper<SysCompanyMessage>().eq("id", id));
        if (sysCompanyMessage != null) {
            return AjaxResult.success(sysCompanyMessage);
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
            @RequestParam(required = false, defaultValue = "10") int pageSize, SysCompanyMessage sysCompanyMessage) {
        try {
            BeanEmptyUtil.setNullValue(sysCompanyMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        QueryWrapper<SysCompanyMessage> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(sysCompanyMessage);
        IPage<SysCompanyMessage> page = new Page<>(pageNo, pageSize);
        page = sysCompanyMessageService.page(page, queryWrapper);
        TableDataInfo tableDataInfo = new TableDataInfo();
        tableDataInfo.setCount(page.getTotal());
        tableDataInfo.setCode(SystemConstants.SUCCESS_CODE);
        tableDataInfo.setData(page.getRecords());
        //返回结果
        return tableDataInfo;
    }

}
