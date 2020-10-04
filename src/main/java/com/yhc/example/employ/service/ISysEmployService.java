package com.yhc.example.employ.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhc.example.employ.domain.SysEmploy;
import com.yhc.example.employ.domain.SysEmployCount;

import java.util.List;

public interface ISysEmployService  extends IService<SysEmploy> {
    public  List<SysEmployCount> selectSysEmployCount();
}
