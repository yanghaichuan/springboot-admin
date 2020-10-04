package com.yhc.example.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.company.domain.SysCompanyMessage;
import com.yhc.example.company.mapper.SysCompanyMessageMapper;
import com.yhc.example.company.service.ISysCompanyMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysCompanyMessageServiceImpl extends ServiceImpl<SysCompanyMessageMapper, SysCompanyMessage> implements ISysCompanyMessageService {
}
