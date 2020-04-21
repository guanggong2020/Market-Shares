package com.example.demo.dao;

import com.example.demo.service.impl.PageUtils;

import java.util.Map;

public interface JtdaDao {
    PageUtils pageJtdByCond(Map<String, Object> params);
    PageUtils findJtdByCodeName(Map<String,Object> params);

}
