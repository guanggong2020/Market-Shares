package com.example.demo.service.impl;

import com.example.demo.dao.Shangzheng_shenzheng_dataDao;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Component
public class Shangzheng_shenzheng_dataImpl implements Shangzheng_shenzheng_dataDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Shangzheng_shenzheng_data> getdatasByName(String name) {

        Query query=new Query();


            query.addCriteria(Criteria.where("code").is(name));

        query.with( Sort.by(Sort.Direction.valueOf("DESC".toUpperCase()),
                "date"));
        query.limit(365);
        List<Shangzheng_shenzheng_data> datas=mongoTemplate.find(query,Shangzheng_shenzheng_data.class);
        System.out.println(datas.size());
        return datas;
    }

    @Override
    public List<Shangzheng_shenzheng_data> getdatasByCode(String code)  {

        Query query=new Query(Criteria.where("code").is(code));
        query.with( Sort.by(Sort.Direction.valueOf("DESC".toUpperCase()),
                "date"));
        query.limit(365);
        List<Shangzheng_shenzheng_data> datas=mongoTemplate.find(query,Shangzheng_shenzheng_data.class);
        return datas;
    }
}
