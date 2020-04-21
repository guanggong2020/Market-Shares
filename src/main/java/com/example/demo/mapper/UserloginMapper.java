package com.example.demo.mapper;

import com.example.demo.entities.Userlogin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("UserloginMapper")
public interface UserloginMapper {

     @Select("select * from userlogin where name=#{name} and password=#{password}")
     Userlogin getUserByNamePassword(String name,String password );

     @Select("select * from userlogin where name=#{name} ")
     List<Userlogin> getUsersByName(String name);


     @Insert("insert into userlogin(name,password,age,description) values(#{name},#{password},#{age},#{description})")
     int insertUser(String name,String password,int age,String description);

     @Delete("delete from userlogin where name=#{name}")
     int deleteByName(String name);
}
