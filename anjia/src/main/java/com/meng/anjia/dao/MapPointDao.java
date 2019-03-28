package com.meng.anjia.dao;

import com.meng.anjia.pojo.AvgPrice;
import com.meng.anjia.pojo.Place;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/28 16:15
 */
@Mapper
@Component
public interface MapPointDao {

    /*条件查询*/
   int findAllMap(@Param("name") String name);

   /*通过名称查询ID*/
    @Select("select * from place where name = #{name}")
    List<Place> getIDByName(@Param("name")String name);

    /*通过UID查询ID*/
    @Select("select * from place where uid = #{id}")
    List<Place> getIDByUid(@Param("id")int id);

    /*通过PID查询最新的房价*/
    @Select("select * from avg_price where pid =#{pid} Order by year DESC, month DESC limit 1")
    List<AvgPrice> getAvgPriceByPid(@Param("pid")int pid);

}
