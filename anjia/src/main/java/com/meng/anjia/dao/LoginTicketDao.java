package com.meng.anjia.dao;

import com.meng.anjia.model.LoginTicket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author yue
 * @date  2019/2/27
 */
@Mapper
@Component
public interface LoginTicketDao {

    @Select("select * from login_ticket where ticket = #{ticket}")
    LoginTicket selectByTicket(String ticket);

    @Insert("insert into login_ticket(userId, expired, status, ticket) values (#{userId},#{expired},#{status},#{ticket})")
    void addTicket(LoginTicket ticket);

    @Update("update login_ticket set status = #{status} where ticket = #{ticket}")
    void updateStatus(@Param("ticket") String ticket, @Param("status")int status);

}
