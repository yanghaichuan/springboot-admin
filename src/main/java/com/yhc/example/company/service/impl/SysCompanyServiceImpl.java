package com.yhc.example.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.company.domain.SysCompany;
import com.yhc.example.company.mapper.SysCompanyMapper;
import com.yhc.example.company.service.ISysCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysCompanyServiceImpl extends ServiceImpl<SysCompanyMapper, SysCompany> implements ISysCompanyService {
}
