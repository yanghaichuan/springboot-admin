package com.yhc.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.domain.entity.Barcode;
import com.yhc.example.domain.mapper.BarcodeMapper;
import com.yhc.example.service.IBarcodeService;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA2018.3
 * author:杨海传
 * Date:2020-07-06 10:42
 */
@Service
public class BarcodeServiceImpl extends ServiceImpl<BarcodeMapper, Barcode> implements IBarcodeService {
}
