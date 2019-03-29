package com.meng.anjia.dao;

import com.meng.anjia.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author shine10076
 * @date 2019/3/19 15:19
 */
@Mapper
@Component
public interface CityDao {


    /**
     * 得到所有城市
     * @param uid 上一级城市id
     * @return 返回城市信息
     */
    @Select("select * from place where uid = #{uid}")
    List<City> getAllCity(int uid);

    /**
     *  根据城市名查询id
     * @param name 城市名
     * @return 返回城市id
     */
    @Select("select id from place where name = #{name} limit 1")
    int getCity(String name);

}
