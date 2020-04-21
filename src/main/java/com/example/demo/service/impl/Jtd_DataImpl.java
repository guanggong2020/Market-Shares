package com.example.demo.service.impl;

import com.example.demo.dao.Jtd_DataDao;
import com.example.demo.entities.Jtd_Data;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Jtd_DataImpl implements Jtd_DataDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Jtd_Data> getdatasByCode(String code) {
        Query query=new Query(Criteria.where("code").is(code));
        System.out.println(code);
        query.with( Sort.by(Sort.Direction.valueOf("DESC".toUpperCase()),
                "date"));
        query.limit(30);
        System.out.println(300);
        List<Jtd_Data> datas=mongoTemplate.find(query,Jtd_Data.class);

        return datas;
    }
}
