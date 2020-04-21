package com.example.demo.controller;

import com.example.demo.dao.GuPiaoDataDao;
import com.example.demo.entities.Gupiao_data;
import com.example.demo.entities.Shangzheng_shenzheng_data;
import com.example.demo.service.impl.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
public class GuPiaoDataController {
    @Autowired
    private GuPiaoDataDao guPiaoDataDao;

    @GetMapping("/data/Amodel")
    public  String returnData(HttpServletRequest request, Model model)  {
        String code=request.getParameter("code");
        List<Gupiao_data> dataList=guPiaoDataDao.getdatasByCode(code);
        model.addAttribute("dataList",dataList);
        System.out.println(dataList.get(0).getName());
        model.addAttribute("name",dataList.get(0).getName());
        return  "echart/SzszModel.html";
    }
    @PostMapping("/K/AData")
    public  String returnAllSingle(@RequestParam("name") String name,Model model){
        List<Gupiao_data> datas=guPiaoDataDao.getdatasByCode(name);
        String result="  ";
        String code="  ";
        if (datas.isEmpty()){

            result=datas.get(0).getName();
            code=datas.get(0).getCode();
        }
        model.addAttribute("datas",datas);
        model.addAttribute("name",result);
        model.addAttribute("code",code);
        return  "K/A.html";
    }
}
