package com.meng.anjia.model;

import java.util.Date;

/**
 * @author yue
 * @date  2019/2/27
 */
public class LoginTicket {
    private int id;
    private int userId;
    private Date expired;
    /**
     * 0有效 1无效
     */
    private int status;
    private String ticket;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
