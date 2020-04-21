package com.example.demo.dao;

import com.example.demo.entities.Gtd;
import com.example.demo.service.impl.PageUtils;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

public interface GtdDao {

    PageUtils pageGtdByCond(Map<String, Object> params);
    List<Gtd> ListAllGtdData();
    PageUtils findGtdByCodeName(Map<String,Object> params);
}
