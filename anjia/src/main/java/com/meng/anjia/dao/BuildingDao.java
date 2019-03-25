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

    /*条件查询*/
    List<Building> findBuildingByCondition(Map<String,Object> map);
    /*条件查询页数返回*/
    int findBuildingByConditionCount(Map<String,Object> map);

    /*按页码和区域查询小区*/
    @Select("select * from property where city = #{city} limit #{number}, 10")
    public List<Building> getBuildingByNumber(@Param("number")int number,@Param("city")String city);

    @Select("select count(*) from property where city = #{city}")
    public int getPageNumber(@Param("city")String city);

    @Select("select * from property where id = #{id}")
    public  Building getBuildingInfoByID(@Param("id")int id);

}