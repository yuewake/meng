package com.meng.anjia.async;

/**
 * @author yue
 * @date  2019/3/18
 */
public enum EventType {

    //喜欢
    LIKE(0),
    //评论
    COMMENT(1),
    //登陆
    LOGIN(2),
    //邮箱
    MAIL(3),
    //不喜欢
    DISLIKE(4),
    //关注
    FOLLOW(5);

    private int value;
    EventType(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
