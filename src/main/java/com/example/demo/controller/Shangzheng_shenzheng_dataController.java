package com.example.demo.controller;

import com.example.demo.dao.Shangzheng_shenzheng_dataDao;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class Shangzheng_shenzheng_dataController {
    @Autowired
    private Shangzheng_shenzheng_dataDao szsz;

   @GetMapping("/data/SZmodel")
    public  String returnShangzheng_shenzheng_data(HttpServletRequest request, Model model)  {
         String code=request.getParameter("code");
         List<Shangzheng_shenzheng_data> dataList=szsz.getdatasByCode(code);
         model.addAttribute("dataList",dataList);
         model.addAttribute("name",dataList.get(0).getName());
        return  "echart/SzszModel.html";
    }
    @PostMapping("/K/SZSZData")
   public  String returnAllSingle(@RequestParam("name") String name,Model model){
         List<Shangzheng_shenzheng_data> datas=szsz.getdatasByName(name);
        String result="  ";
        String code="  ";
        if (!datas.isEmpty()){


            result=datas.get(0).getName();
            code=datas.get(0).getCode();
        }
         model.addAttribute("datas",datas);
         model.addAttribute("name",result);
         model.addAttribute("code",code);
       return  "K/SZSZ.html";
   }
}
