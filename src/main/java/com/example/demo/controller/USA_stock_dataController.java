package com.example.demo.controller;

import com.example.demo.dao.USA_stock_dataDao;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import com.example.demo.entities.USA_stock_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
@Controller
public class USA_stock_dataController {
    @Autowired
    private USA_stock_dataDao usa_stock_dataDao;

    @GetMapping("/data/USAmodel")
    public  String returnDatas(HttpServletRequest request, Model model)  {
        String code=request.getParameter("code");

        List<USA_stock_data> dataList=usa_stock_dataDao.getdatasByCode(code);
        model.addAttribute("dataList",dataList);
        System.out.println(dataList.get(0).getName());
        model.addAttribute("name",dataList.get(0).getName());
        return  "echart/SzszModel.html";
    }
    @PostMapping("/K/USAData")
    public  String returnKDatas(String name,Model model){
        List<USA_stock_data> dataList=usa_stock_dataDao.getdatasByCode(name);
       String result="  ";
       String code="  ";
        if (!dataList.isEmpty()){
            result=dataList.get(0).getName();
            code=dataList.get(0).getCode();
       }
        model.addAttribute("datas",dataList);
        model.addAttribute("name",result);
        model.addAttribute("code",code);
        return "K/USA.html";
    }
}
