package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("page/button")
    public String loginPage(Model model){return  "buttons.html";}

    @GetMapping("page/tables")
    public String tablesPage(Model model){return "tables.html";}
    @GetMapping("page/index")
    public  String indexPage(){return "index.html";}
    @GetMapping("page/usa")
     public  String USAPage(){return "page/USA.html";}
    @GetMapping("page/sz")
    public  String SZPage(){return "page/SZ.html";}
    @GetMapping("page/zstd")
    public  String ZstdPage(){return "page/Zstd.html";}
    @GetMapping("page/jtd")
    public   String JtdPage(){return  "page/Jtd.html";}
    @GetMapping("K/A")
    public  String KAPage(){return "K/A.html";}
    @GetMapping("K/USA")
    public  String KUSAPage(){return "K/USA.html";}
    @GetMapping("/K/SZSZ")
    public  String KSZSZPage(){return "K/SZSZ.html";}

    @GetMapping("/page/USA_fund")
    public  String USA_fundPage(){return "page/USA_fund.html";}
}
