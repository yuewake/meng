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

    @Select("select * from rank")
    List<Rank> getAllRank();

    @Select("select * from rank where city = #{city}")
    Rank getRankByCity(@Param("city")String city);
}
