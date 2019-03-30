package com.meng.anjia.dao;

import com.meng.anjia.model.Prediction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/25 10:17
 */
@Mapper
@Component
public interface PredictionDao {

    /**
     * 根据城市 名称得到预测信息
     * @param city
     * @return
     */
    @Select("select * from prediction where city = #{city}")
    public Prediction getPredictionByName(String city);

    /**
     * 得到所有城市名称
     * @return
     */
    @Select("select city from prediction ")
    public List<String> getCityList();
}
