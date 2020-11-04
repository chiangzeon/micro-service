package com.xiangxue.micro.order.controller;

import com.xiangxue.micro.order.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class IndexController {

    @Autowired
    private BillService billService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("currentDate")
    public String currentDate(){
        return String.valueOf(billService.currentDate());
    }
}
