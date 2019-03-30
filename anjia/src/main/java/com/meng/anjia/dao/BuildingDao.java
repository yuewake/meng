package com.meng.anjia.dao;

import com.meng.anjia.model.Building;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author shine10076
 * @date 2019/3/19 15:32
 */
@Mapper
@Component
public interface BuildingDao {

    /**
     * 根据条件查询到小区信息
     * @param map 参数列表
     * @return 返回小区信息
     */
    List<Building> findBuildingByCondition(Map<String,Object> map);


    /**
     * 根据条件查询到小区
     * @param map 参数列表
     * @return 返回小区信息
     */
    int findBuildingByConditionCount(Map<String,Object> map);

    /**
     * 按页数查询小区
     * @param number 小区序号
     * @param city 城市名
     * @return 返回小区信息
     */
    @Select("select * from property where city = #{city} limit #{number}, 10")
    public List<Building> getBuildingByNumber(@Param("number")int number,@Param("city")String city);

    /**
     * 按城市名查询小区数量
     * @param city 城市名
     * @return 返回小区数量
     */
    @Select("select count(*) from property where city = #{city}")
    public int getPageNumber(@Param("city")String city);

    /**
     * 按id查询小区
     * @param id id
     * @return 返回小区信息
     */
    @Select("select * from property where id = #{id}")
    public  Building getBuildingInfoByID(@Param("id")int id);

    /**
     * 按城市名随机取小区
     * @param city 城市名
     * @return 返回小区信息
     */
    @Select("select * from property where city = #{city} order by RAND() limit 4")
    public List<Building> getRandomBuilding(@Param("city")String city);

    /**
     * 按城市名查询小区
     * @param city 城市名
     * @return 返回小区信息
     */
    @Select("select * from property where city = #{city}")
    public List<Building> getAllBuildingByCity(@Param("city")String city);

}
