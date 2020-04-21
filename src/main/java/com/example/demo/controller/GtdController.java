package com.example.demo.controller;

import com.example.demo.dao.GtdDao;
import com.example.demo.service.impl.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GtdController {

    @Autowired
    private GtdDao gtdDao;

    @ResponseBody
    @GetMapping("/page/Gtd")
    public PageUtils loadFromMongo(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils=pageUtils=gtdDao.pageGtdByCond(params);

        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/page/GtdJuge")
    public PageUtils loadJugeFromMongo(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils=pageUtils=gtdDao.findGtdByCodeName(params);

        return pageUtils;
    }


}
