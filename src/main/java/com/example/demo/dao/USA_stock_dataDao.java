package com.example.demo.dao;

import com.example.demo.entities.Shangzheng_shenzheng_data;
import com.example.demo.entities.USA_stock_data;

import java.util.List;

public interface USA_stock_dataDao {

    List<USA_stock_data> getdatasByCode(String code) ;
}
