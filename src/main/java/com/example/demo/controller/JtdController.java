package com.example.demo.controller;

import com.example.demo.dao.JtdaDao;
import com.example.demo.service.impl.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class JtdController {
    @Autowired
    private JtdaDao jtdDao;
    @ResponseBody
    @GetMapping("/page/Jtd")
    public PageUtils loadFromMongo(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils=jtdDao.pageJtdByCond(params);


        return pageUtils;
    }
    @ResponseBody
    @GetMapping("/page/JtdJuge")
    public PageUtils loadJugeFromMongo(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils=jtdDao.findJtdByCodeName(params);


        return pageUtils;
    }

}
