package com.meng.anjia.dao;

import com.meng.anjia.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CityDao {


    @Select("select * from place where uid = #{uid}")
    List<City> getAllCity(int uid);

    @Select("select id from place where name = #{name}")
    int getCity(String name);

}
