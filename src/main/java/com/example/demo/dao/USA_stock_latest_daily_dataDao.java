package com.example.demo.dao;

import com.example.demo.service.impl.PageUtils;

import java.util.Map;

public interface USA_stock_latest_daily_dataDao {
    PageUtils pageUSAByCond(Map<String, Object> params);
    PageUtils findUSAByCodeName(Map<String,Object> params);
    PageUtils findUSAByCondition(Map<String,Object> params);
}
