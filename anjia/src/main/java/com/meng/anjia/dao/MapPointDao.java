package com.meng.anjia.dao;

import com.meng.anjia.model.MapPoint;
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

    /**
     * 根据名字查询所有的价格
     * @param name
     * @return
     */
   List<MapPoint> findAllPriceByName(@Param("name") String name);


    /**
     * 根据名称查询ID
     * @param name
     * @return
     */
    @Select("select * from place where name = #{name}")
    List<Place> getIDByName(@Param("name")String name);

    /**
     * 根据UID查询ID
     * @param id
     * @return
     */
    @Select("select * from place where uid = #{id}")
    List<Place> getIDByUid(@Param("id")int id);

    /**
     * 根据pid查询最新房价
     * @param pid
     * @return
     */
    @Select("select * from avg_price where pid =#{pid} Order by year DESC, month DESC limit 1")
    List<AvgPrice> getAvgPriceByPid(@Param("pid")int pid);


}
