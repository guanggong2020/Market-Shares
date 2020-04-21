package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.dao.GuPiaoDataDao;
import com.example.demo.entities.Gupiao_data;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;



@Component
public class GuPiaoDataImpl implements GuPiaoDataDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Gupiao_data> getdatasByCode(String code) {
        Query query=new Query(Criteria.where("code").is(code));
        System.out.println(code);
        query.with( Sort.by(Sort.Direction.valueOf("DESC".toUpperCase()),
                "date"));
        query.limit(365);
        System.out.println(code);
        List<Gupiao_data> datas=mongoTemplate.find(query,Gupiao_data.class);
        System.out.println(datas.size());
        return datas;
    }
}
