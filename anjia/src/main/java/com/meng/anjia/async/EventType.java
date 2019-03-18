package com.meng.anjia.async;

/**
 * Created by yue on 2019/3/18
 */
public enum EventType {
    LIKE(0),COMMENT(1),LOGIN(2),MAIL(3),DISLIKE(4),FOLLOW(5);

    private int value;
    EventType(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
