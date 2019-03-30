package com.meng.anjia.async;

import java.util.List;

/**
 * @author yue
 * @date  2019/3/18
 */
public interface EventHandler {
    void doHandle(EventModel model);
    List<EventType> getSupportEventTypes();//存有它支持处理的事件类型
}
