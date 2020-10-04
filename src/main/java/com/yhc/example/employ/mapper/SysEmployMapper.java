package com.yhc.example.employ.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhc.example.employ.domain.SysEmploy;
import com.yhc.example.employ.domain.SysEmployCount;

import java.util.List;

public interface SysEmployMapper extends BaseMapper<SysEmploy> {
    List<SysEmployCount> selectSysEmployCount();
}
