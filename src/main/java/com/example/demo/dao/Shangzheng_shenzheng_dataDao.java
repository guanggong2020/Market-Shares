package com.example.demo.dao;

import com.example.demo.entities.Shangzheng_shenzheng_data;

import java.text.ParseException;
import java.util.List;

public interface Shangzheng_shenzheng_dataDao  {
    List<Shangzheng_shenzheng_data> getdatasByName(String name) ;
    List<Shangzheng_shenzheng_data> getdatasByCode(String code) ;
}
