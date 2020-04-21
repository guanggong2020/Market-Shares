package com.example.demo.controller;


import com.example.demo.Ju.Md5;

import com.example.demo.mapper.UserloginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Controller
public class LoginController {

     @Autowired
     UserloginMapper userMapper;
    @GetMapping("user/login")
     public String loginPage(Model model){return  "login.html";}


     @PostMapping("user/login")
     public String login(@RequestParam("name") String name,
                         @RequestParam("password") String password,
                         Map<String, Object> map, HttpSession session,Model model) {
         if(userMapper.getUsersByName(name).isEmpty()) {
             map.put("msg","用户名错误");
             return "login.html";
         } else{
             Md5 md5=new Md5();
             password=md5.EncoderByMd5(password);
             if (userMapper.getUserByNamePassword(name,password)!=null){
                session.setAttribute("name",name);
                 model.addAttribute("loginName",name);
                 return "index.html";
             }else {
                 map.put("msg","密码错误");
                 return "login.html";
             }
         }

     }


       @GetMapping("user/register")
       public String registerPage(Model model){
         return "user/register.html";
       }

       @PostMapping("user/register")
       public  String register(@RequestParam("name")String name,
                               @RequestParam("password")String password,
                               @RequestParam("age")Integer age,
                               @RequestParam("description") String description, Map<String, Object> map,  HttpSession session){
           if (userMapper.getUsersByName(name).isEmpty()){
               if (name.isEmpty()){
                   map.put("msg","用户名不能为空");
               }else{
                   if (password.isEmpty()){
                       map.put("msg","密码不能为空");
                   }else{
                       if (age==0){
                           map.put("msg","年龄不能为空");
                       }else{
                           if (name.isEmpty()){
                               map.put("msg","描述不能为空");
                           }else{
                               Md5 md5=new Md5();
                                   password=md5.EncoderByMd5(password);
                               if (userMapper.insertUser(name, password, age, description)==1){
                                   return "login.html";
                               }
                           }
                       }
                   }
               }
           }else{
               map.put("msg","用户已存在");

           }



         return "user/register.html";
       }
       @GetMapping("/delete")
       public String deleteAndreturnLogin(HttpSession session){
        System.out.println(session.getAttribute("name"));
          userMapper.deleteByName(session.getAttribute("name").toString());
        return "login.html";
       }



}
