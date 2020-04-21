package com.example.demo.dao;

import com.example.demo.entities.Gupiao_data;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import com.example.demo.service.impl.PageUtils;

import java.util.List;
import java.util.Map;

public interface GuPiaoDataDao {

    List<Gupiao_data> getdatasByCode(String code) ;

}
