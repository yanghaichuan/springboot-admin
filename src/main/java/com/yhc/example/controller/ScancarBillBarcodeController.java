package com.yhc.example.controller;


import com.yhc.example.bean.Response;
import com.yhc.example.service.IScancarBillBarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/scan/bill/barcode")
public class ScancarBillBarcodeController {

    @Autowired
    private IScancarBillBarcodeService scancarBillBarcodeService;

    @Autowired
    private Response response;

}
