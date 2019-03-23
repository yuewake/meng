package com.meng.anjia.service;

import com.meng.anjia.dao.BuildingDao;
import com.meng.anjia.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shine10076
 * @date 2019/3/19 18:45
 */
@Service
public class BuildingService {

    @Autowired
    BuildingDao buildingDao;

    /**
     * 按页数返回小区列表
     * @param number
     * @param city
     * @return
     */
    public List<Building> getBuildingByNumber(int number, String city)
    {
        return buildingDao.getBuildingByNumber(number, city);
    }


    /**
     * 返回小区总页数
     * @param city
     * @return
     */
    public int getPageNumber(String city)
    {
        return buildingDao.getPageNumber(city);
    }

    /**
     * 返回条件查询小区列表
     * @param map
     * @return
     */
    public List<Building> findBuildingByCondition(Map<String,Object> map)
    {
        return buildingDao.findBuildingByCondition(map);
    }

    /**
     * 返回条件查询小区数量
     * @param map
     * @return
     */
    public int findBuildingByConditionCount(Map<String,Object> map)
    {
        return buildingDao.findBuildingByConditionCount(map);
    }

    /**
     *根据小区id返回具体信息
     * @param id
     * @return
     */
    public Building getBuildingInfo(int id)
    {
        return buildingDao.getBuildingInfoByID(id);
    }
}
