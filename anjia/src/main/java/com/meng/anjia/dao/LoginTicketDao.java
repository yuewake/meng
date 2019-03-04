package com.meng.anjia.dao;

import com.meng.anjia.model.LoginTicket;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoginTicketDao {

    @Select("select * from login_ticket where ticket = #{ticket}")
    LoginTicket selectByTicket(String ticket);

    @Insert("insert into login_ticket(userId, expired, status, ticket) values (#{userId},#{expired},#{status},#{ticket})")
    void addTicket(LoginTicket ticket);

    @Update("update login_ticket set status = #{status} where ticket = #{ticket}")
    void updateStatus(String ticket, int status);

}
