package com.xiangxue.micro.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiangxue.micro.entities.order.Bill;

import java.util.Date;

public interface BillService extends IService<Bill> {

    Date currentDate();
}
