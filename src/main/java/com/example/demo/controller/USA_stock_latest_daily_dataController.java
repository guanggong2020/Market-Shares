package com.example.demo.controller;

import com.example.demo.dao.USA_stock_latest_daily_dataDao;
import com.example.demo.service.impl.PageUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class USA_stock_latest_daily_dataController {
    @Autowired
    private USA_stock_latest_daily_dataDao u;


    @ResponseBody
    @GetMapping("/page/USA")
    public PageUtils loadFromMongo(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils=null;


        if (StringUtils.isNotBlank(params.get("search").toString())){
            pageUtils=u.findUSAByCodeName(params);
        }else{
            pageUtils=u.pageUSAByCond(params);
        }
        System.out.println(pageUtils.getRows());
        return pageUtils;
    }
    @ResponseBody
    @GetMapping("/page/USAJuge")
    public PageUtils loadConditionFromMongo(@RequestParam Map<String, Object> params) {

        PageUtils pageUtils=u.findUSAByCodeName(params);
        return pageUtils;
    }
}
