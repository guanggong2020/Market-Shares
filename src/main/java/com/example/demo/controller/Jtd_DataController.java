package com.example.demo.controller;

import com.example.demo.dao.Jtd_DataDao;
import com.example.demo.entities.Jtd_Data;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class Jtd_DataController {
    @Autowired
    private Jtd_DataDao jtd_dataDao;
    @GetMapping("/data/JtdModel")
    public  String returnShangzheng_shenzheng_data(HttpServletRequest request, Model model)  {
        String code=request.getParameter("code");

        List<Jtd_Data> dataList=jtd_dataDao.getdatasByCode(code);
        System.out.println(dataList);
        model.addAttribute("dataList",dataList);
        return  "echart/JtdModel.html";
    }


}
