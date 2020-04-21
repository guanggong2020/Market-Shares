package com.example.demo.controller;

import com.example.demo.dao.USA_fund_latest_daily_dataDao;
import com.example.demo.service.impl.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class USA_fund_latest_daily_dataController {

    @Autowired
    private USA_fund_latest_daily_dataDao usa_fund_latest_daily_dataDao;

    @ResponseBody
    @GetMapping("/page/USAfund")
    public PageUtils loadFromMongo(@RequestParam Map<String, Object> params) {

        PageUtils pageUtils=usa_fund_latest_daily_dataDao.pageUSA_fund_latest_daily_dataByCond(params);

        return pageUtils;
    }
    @ResponseBody
    @GetMapping("/page/USAfundJuge")
    public PageUtils loadJugeFromMongo(@RequestParam Map<String, Object> params) {

        PageUtils pageUtils=usa_fund_latest_daily_dataDao.findUSA_fundByCodeName(params);

        return pageUtils;
    }
}
