package com.example.demo.dao;

import com.example.demo.service.impl.PageUtils;

import java.util.Map;

public interface USA_fund_latest_daily_dataDao {
    PageUtils pageUSA_fund_latest_daily_dataByCond(Map<String, Object> params);
    PageUtils findUSA_fundByCodeName(Map<String,Object> params);
}
