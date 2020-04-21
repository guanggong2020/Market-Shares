package com.example.demo.service.impl;

import com.example.demo.dao.USA_stock_dataDao;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import com.example.demo.entities.USA_stock_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class USA_stock_dataImpl implements USA_stock_dataDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<USA_stock_data> getdatasByCode(String code) {
        Query query=new Query();
        query.addCriteria(Criteria.where("code").is(code));
        System.out.println(code);
        query.with( Sort.by(Sort.Direction.valueOf("DESC".toUpperCase()),
                "date"));
        query.limit(300);
        List<USA_stock_data> datas=mongoTemplate.find(query,USA_stock_data.class);
        System.out.println(datas.size());
        return datas;
    }
}
