package com.example.demo.service.impl;

import com.example.demo.dao.USA_stock_latest_daily_dataDao;
import com.example.demo.entities.Gupiao_data;
import com.example.demo.entities.USA_stock_latest_daily_data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class USA_stock_latest_daily_dataImpl implements USA_stock_latest_daily_dataDao {

    @Autowired
    private   MongoTemplate mongoTemplate;


    @Override
    public PageUtils pageUSAByCond(Map<String, Object> params) {
        int offset = 0;
        int limit = 10;
        if (null != params) {

            if (StringUtils.isNotBlank(params.get("offset").toString())) {
                offset = Integer.parseInt(params.get("offset").toString());
            }
            if (StringUtils.isNotBlank(params.get("limit").toString())) {
                limit = Integer.parseInt(params.get("limit").toString());
            }
        }

        Query query = new Query(new Criteria());
        if (StringUtils.isNotBlank(params.get("sort").toString())
                && StringUtils.isNotBlank(params.get("order").toString())) {
            query.with( Sort.by(Sort.Direction.valueOf(params.get("order").toString().toUpperCase()),
                    params.get("sort").toString()));
        }
        query.skip(offset);
        query.limit(limit);

        List<USA_stock_latest_daily_data> usa = mongoTemplate.find(query, USA_stock_latest_daily_data.class);
        PageUtils pageUtils = new PageUtils(new ArrayList<>(), 0);
        pageUtils.setRows(usa);
        pageUtils.setTotal(1000);
        System.out.println(pageUtils);
        return pageUtils;

    }

    @Override
    public PageUtils findUSAByCodeName(Map<String, Object> params) {
        String find=params.get("search").toString();
        int offset = 0;
        int limit = 10;
        if (null != params) {

            if (StringUtils.isNotBlank(params.get("offset").toString())) {
                offset = Integer.parseInt(params.get("offset").toString());
            }
            if (StringUtils.isNotBlank(params.get("limit").toString())) {
                limit = Integer.parseInt(params.get("limit").toString());
            }
        }
        Query query = new Query();
        if (find!= null && find.length() > 0) {
            Pattern pattern = Pattern.compile("^.*" + find + ".*$", Pattern.CASE_INSENSITIVE);
            if (find.matches("\\d+"))
                query.addCriteria(Criteria.where("code").regex(pattern));
            else
                query.addCriteria(Criteria.where("name").regex(pattern));
        }
        if(!params.get("change").toString().equals("0")){

            query.addCriteria(Criteria.where("turnoverRate").gt(Double.parseDouble(params.get("change").toString())));
        }
        long recordTotal = mongoTemplate.count(query, USA_stock_latest_daily_data.class, "USA_stock_latest_daily_data");
        query.skip(offset).limit(limit);
        query.with( Sort.by(Sort.Direction.valueOf(params.get("order").toString().toUpperCase()),
                params.get("sort").toString()));
       List<USA_stock_latest_daily_data> usa=mongoTemplate.find(query, USA_stock_latest_daily_data.class,"USA_stock_latest_daily_data");

        PageUtils pageUtils = new PageUtils(new ArrayList<>(), 0);
        pageUtils.setRows(usa);
        pageUtils.setTotal(recordTotal);
        return pageUtils;
    }

    @Override
    public PageUtils findUSAByCondition(Map<String, Object> params) {
        return null;
    }
}
