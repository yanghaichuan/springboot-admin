package com.yhc.example.company.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhc.example.bean.AjaxResult;
import com.yhc.example.bean.BeanEmptyUtil;
import com.yhc.example.bean.TableDataInfo;
import com.yhc.example.company.domain.SysCompanyRecruit;
import com.yhc.example.company.service.ISysCompanyRecruitService;
import com.yhc.example.constant.SystemConstants;
import com.yhc.example.constant.UserMsgContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * sys_company
 *
 * @author yhc 2020-09-26
 */
@Controller
@RequestMapping("/company/recruit")
public class SysCompanyRecruitController {

    @Autowired
    private ISysCompanyRecruitService sysCompanyRecruitService;

    /**
     * 列表
     * @return
     */
    @GetMapping("/recruit-list")
    public String list() {
        return "pages/company/recruit-list";
    }



    /**
     * 新增
     * @return
     */
    @GetMapping("/recruit-insert")
    public String insert() {
        return "pages/company/recruit-insert";
    }

    /**
     * 修改
     * @return
     */
    @GetMapping("/recruit-update")
    public String edit() {
        return "pages/company/recruit-update";
    }


    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(SysCompanyRecruit sysCompanyRecruit) {
        sysCompanyRecruit.setCreateTime(new Date());
        if(sysCompanyRecruit.getStatus() == null){
            sysCompanyRecruit.setStatus("1");
        }
        if (sysCompanyRecruit.getId() != null) {
            SysCompanyRecruit sysCompanyRecruit1 = sysCompanyRecruitService.getOne(new QueryWrapper<SysCompanyRecruit>().eq("id", sysCompanyRecruit.getId()));
            if (sysCompanyRecruit1 != null) {
                sysCompanyRecruitService.updateById(sysCompanyRecruit);
                return AjaxResult.success();
            }
        }else{
            boolean flag = sysCompanyRecruitService.save(sysCompanyRecruit);
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
            boolean flag= sysCompanyRecruitService.removeByIds(userList);
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
        SysCompanyRecruit sysCompanyRecruit = sysCompanyRecruitService.getOne(new QueryWrapper<SysCompanyRecruit>().eq("id", id));
        if (sysCompanyRecruit != null) {
            return AjaxResult.success(sysCompanyRecruit);
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
            @RequestParam(required = false, defaultValue = "10") int pageSize, SysCompanyRecruit sysCompanyRecruit) {
        try {
            BeanEmptyUtil.setNullValue(sysCompanyRecruit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        QueryWrapper<SysCompanyRecruit> queryWrapper = new QueryWrapper<>();
        if(sysCompanyRecruit.getTitle()!=null){
            queryWrapper.like("title",sysCompanyRecruit.getTitle());
        }

        if(sysCompanyRecruit.getCompany()!=null){
            queryWrapper.like("company",sysCompanyRecruit.getCompany());
        }

        if(sysCompanyRecruit.getStatus()!=null){
            queryWrapper.like("status",sysCompanyRecruit.getStatus());
        }

        if(sysCompanyRecruit.getExpiredTime()!=null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sysCompanyRecruit.getExpiredTime());
            calendar.add(Calendar.MONTH,-2);
            queryWrapper.between("expired_time",calendar.getTime(),sysCompanyRecruit.getExpiredTime());
        }

        IPage<SysCompanyRecruit> page = new Page<>(pageNo, pageSize);
        page = sysCompanyRecruitService.page(page, queryWrapper);
        TableDataInfo tableDataInfo = new TableDataInfo();
        tableDataInfo.setCount(page.getTotal());
        tableDataInfo.setCode(SystemConstants.SUCCESS_CODE);
        tableDataInfo.setData(page.getRecords());
        //返回结果
        return tableDataInfo;
    }

}
