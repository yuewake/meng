package com.meng.anjia.model;

import org.springframework.stereotype.Component;

/**
 * @author yue
 * @date  2019/3/1
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();;
    }
}
