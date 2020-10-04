package com.yhc.example.employ.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.employ.domain.SysEmploy;
import com.yhc.example.employ.domain.SysEmployCount;
import com.yhc.example.employ.mapper.SysEmployMapper;
import com.yhc.example.employ.service.ISysEmployService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SysEmployServiceImpl extends ServiceImpl<SysEmployMapper, SysEmploy> implements ISysEmployService {
    @Autowired
    private SysEmployMapper sysEmployMapper;

    public List<SysEmployCount> selectSysEmployCount(){
        return sysEmployMapper.selectSysEmployCount();
    }
}
