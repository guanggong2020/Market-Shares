package com.example.demo.dao;

import com.example.demo.service.impl.PageUtils;

import java.util.Map;

public interface ZstdDao  {

    PageUtils pageZstdByCond(Map<String, Object> params);
    PageUtils findZstdByCodeName(Map<String,Object> params);

}
