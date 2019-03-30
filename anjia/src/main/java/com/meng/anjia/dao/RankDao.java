package com.meng.anjia.dao;

import com.meng.anjia.model.Rank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/24 19:47
 */
@Mapper
@Component
public interface RankDao {

    /**
     * 得到所有的预测数据
     * @return
     */
    @Select("select * from rank")
    List<Rank> getAllRank();

    /**
     * 根据城市名得到预测数据
     * @param city
     * @return
     */
    @Select("select * from rank where city = #{city}")
    Rank getRankByCity(@Param("city")String city);
}
