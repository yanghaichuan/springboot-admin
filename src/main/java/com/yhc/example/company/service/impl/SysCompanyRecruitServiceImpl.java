package com.yhc.example.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.company.domain.SysCompanyRecruit;
import com.yhc.example.company.mapper.SysCompanyRecruitMapper;
import com.yhc.example.company.service.ISysCompanyRecruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysCompanyRecruitServiceImpl extends ServiceImpl<SysCompanyRecruitMapper, SysCompanyRecruit> implements ISysCompanyRecruitService {
}
