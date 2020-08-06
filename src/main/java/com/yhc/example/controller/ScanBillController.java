package com.yhc.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhc.example.bean.Response;
import com.yhc.example.constant.UserMsgContants;
import com.yhc.example.domain.entity.ScanBill;
import com.yhc.example.redis.RedisUtil;
import com.yhc.example.service.IScanBillService;
import com.yhc.example.util.SequenceUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/scan/bill")
public class ScanBillController {

    @Autowired
    private IScanBillService scanBillService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private Response response;

    @GetMapping("/list")
    @RequiresPermissions("scan:scan:list")
    public Response list() {
        List<ScanBill> scanBillList = scanBillService.list();
        return response.success("查询成功", scanBillList);
    }

    @GetMapping("/get")
    @RequiresPermissions("scan:scan:get")
    public Response get(String pid) {
        if (pid == null || pid.equals("")) {
            return response.failure("参数不正确");
        }
        QueryWrapper<ScanBill> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("f_pid", pid);
        ScanBill scanBill = scanBillService.getOne(queryWrapper);
        return response.success(UserMsgContants.SUCCESS, scanBill);
    }

    /**
     * 获取流水号
     *
     * @return
     */
    @GetMapping("/getDataNo")
    public Response getDataNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str = sdf.format(new Date());
        str = "S" + str;
        this.redisUtil.incr(str, 1);
        Object seq = this.redisUtil.get(str);
        String number = SequenceUtils.getSequence(Long.parseLong(seq.toString()));
        return response.success(UserMsgContants.SUCCESS, str+number);
    }


}
