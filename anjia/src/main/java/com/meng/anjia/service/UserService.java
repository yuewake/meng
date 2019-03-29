package com.meng.anjia.service;

import com.meng.anjia.dao.LoginTicketDao;
import com.meng.anjia.dao.UserDao;
import com.meng.anjia.model.LoginTicket;
import com.meng.anjia.model.User;
import com.meng.anjia.util.AnjiaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    LoginTicketDao loginTicketDao;

    /**
     * 注册
     * @param user
     * @return
     */
    public Map<String, Object> regist(User user) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        if (user.getUsername() == null || "".equals(user.getUsername().trim())) {
            map.put("msg", "用户名为空");
            return map;
        } else if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
            map.put("msg", "密码为空");
            return map;
        } else if (userDao.selectByName(user.getUsername()) != null) {
            map.put("msg", "用户名已被注册");
            return map;
        } else {
            String salt = UUID.randomUUID().toString().replaceAll("-", "");
            user.setSalt(salt);
            user.setPassword(AnjiaUtil.MD5(salt + user.getPassword()));
            userDao.insertUser(user);
            return map;
        }
    }

    /**
     * 登陆
     * @param user
     * @return
     */
    public Map<String, Object> login(User user){
        Map<String, Object> map = new HashMap<String, Object>(1);
        if(user.getPassword() == null || "".equals(user.getPassword().trim())){
            map.put("msg","密码不能为空");
            return map;
        }
        if(user.getUsername() == null || "".equals(user.getUsername().trim())){
            map.put("msg","用户名不能为空");
            return map;
        }
        User u = userDao.selectByName(user.getUsername());
        if(u == null){
            map.put("msg","用户名不存在");
            return map;
        }
        if(!u.getPassword().equals(AnjiaUtil.MD5(u.getSalt() + user.getPassword()))){
            map.put("msg","密码错误");
            return map;
        }
        //所有都准确无误的情况下 创建一个ticket给这个用户
        String ticket = addLoginTicket(u.getId());
        map.put("ticket", ticket);
        return map;
    }

    /**
     * 添加ticket
     * @param userId
     * @return
     */
    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);//设置过期时间为24小时
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDao.addTicket(ticket);
        return ticket.getTicket();
    }

    public void logout(String ticket){
        loginTicketDao.updateStatus(ticket, 1);
    }

    public User getUser(int userId) {
        return userDao.selectById(userId);
    }
}
