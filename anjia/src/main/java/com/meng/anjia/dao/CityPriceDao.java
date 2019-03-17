package com.meng.anjia.dao;

import com.meng.anjia.model.CityPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/13 14:21
 */
@Mapper
@Component
public interface CityPriceDao {

    @Select("select * from avg_price where name = #{name} order by year, month ")
    List<CityPrice> getAllCityPrice(String name);

    @Select("select * from avg_price where pid = #{id} order by year, month ")
    List<CityPrice> getAllCityPriceByID(int id);

    @Select("select * from avg_price where name = #{name} order by year desc, month desc limit 1")
    CityPrice getFirstCityPrice(String name);

    @Select("select * from avg_price where id = #{id} order by year desc, month desc limit 1")
    CityPrice getFirstCityPriceByID(int id);

}
