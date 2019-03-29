package com.meng.anjia.dao;

import com.meng.anjia.model.Probability;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author shine10076
 * @date 2019/3/26 11:20
 */
@Mapper
@Component
public interface ProbabilityDao {

    /**
     * 根据城市名得到预测结果
     * @param city
     * @return
     */
    @Select("select * from probability where city = #{city}")
    public Probability getProbabilityByCity(@Param("city")String city);

}
