package com.meng.anjia.dao;

import com.meng.anjia.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by yue on 2019/3/4
 */
@Mapper
@Component
public interface UserDao {

    void insertUser(User user);

    @Select("select * from user where username = #{username}")
    User selectByName(String username);

    @Select("select * from user where id = #{id}")
    User selectById(int id);
}
