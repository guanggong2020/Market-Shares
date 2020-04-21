package com.example.demo.dao;

import com.example.demo.entities.Jtd_Data;

import java.util.List;

public interface Jtd_DataDao {


    List<Jtd_Data> getdatasByCode(String code) ;

}
