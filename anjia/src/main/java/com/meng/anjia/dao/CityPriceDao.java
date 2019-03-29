package com.meng.anjia.dao;

import com.meng.anjia.model.CityPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    /**
     *  得到所有区域最新价格
     * @param name
     * @return
     */
    @Select("select * from avg_price where name = #{name} order by year, month ")
    List<CityPrice> getAllCityPrice(String name);

    /**
     * 根据上一级区域id查询区域
     * @param id
     * @return
     */
    @Select("select * from avg_price where pid = #{id} order by year, month ")
    List<CityPrice> getAllCityPriceByID(int id);

    /**
     * 根据城市名得到最新的价格
     * @param name
     * @return
     */
    @Select("select * from avg_price where name = #{name} order by year desc, month desc limit 1")
    CityPrice getFirstCityPrice(String name);

    /**
     * 根据 id 得到平均价格
     * @param id
     * @return
     */
    @Select("select * from avg_price where id = #{id} order by year desc, month desc limit 1")
    CityPrice getFirstCityPriceByID(int id);

    /**
     * 根据名称得到最近半年的数据
     * @param name
     * @return
     */
    @Select("select * from avg_price where name = #{name} order by year desc, month desc limit 6 ")
    List<CityPrice> getCityPriceHalfYear(String name);

    /**
     * 根据名称得到所有区域的价格
     * @param name
     * @param number
     * @return
     */
    @Select("select * from avg_price where name = #{name} order by year, month limit #{number}, 10 ")
    List<CityPrice> getAllCityPricePage(@Param("name") String name, @Param("number")int number);
}
