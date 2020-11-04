package com.xiangxue.micro.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiangxue.micro.entities.order.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface BillMapper extends BaseMapper<Bill> {
}
