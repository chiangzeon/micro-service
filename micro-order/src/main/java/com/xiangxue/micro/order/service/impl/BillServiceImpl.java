package com.xiangxue.micro.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiangxue.micro.entities.order.Bill;
import com.xiangxue.micro.order.dao.BillMapper;
import com.xiangxue.micro.order.service.BillService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {


    @GlobalTransactional
    @Override
    public Date currentDate() {
        Bill bill = new Bill();
        save(bill);
        return new Date();
    }
}
