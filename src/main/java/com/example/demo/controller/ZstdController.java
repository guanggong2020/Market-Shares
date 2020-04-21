package com.example.demo.controller;


import com.example.demo.dao.ZstdDao;
import com.example.demo.entities.Zstd;
import com.example.demo.service.impl.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ZstdController {

    @Autowired
     private  ZstdDao zstdDao;
    @ResponseBody
    @GetMapping("/page/Zstd")
    public PageUtils loadFromMongo(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils=pageUtils=zstdDao.pageZstdByCond(params);
        return pageUtils;
    }
    @ResponseBody
    @GetMapping("/page/ZstdJuge")
    public PageUtils loadJugeFromMongo(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils=pageUtils=zstdDao.findZstdByCodeName(params);
        return pageUtils;
    }
}
