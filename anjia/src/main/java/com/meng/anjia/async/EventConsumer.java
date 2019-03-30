package com.meng.anjia.async;

import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.util.JedisAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author yue
 * @date  2019/3/18
 */
@Component
public class EventConsumer implements InitializingBean {
    @Autowired
    JedisAdapter jedisAdapter;

    @Autowired
    private ApplicationContext applicationContext;

    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);
    private Map<EventType, List<EventHandler>> config = new HashMap<EventType, List<EventHandler>>();

    @Override
    public void afterPropertiesSet() throws Exception {
        //获取所有的handler实例
        Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
        //遍历 获取某一XXXHandler支持的事件类型
        for (Map.Entry<String, EventHandler> map : beans.entrySet()) {
            List<EventType> le = map.getValue().getSupportEventTypes();
            for (EventType et : le) {
                if(config.containsKey(et)){
                    config.get(et).add(map.getValue());
                }else {
                    List<EventHandler> evntHs = new LinkedList<>();
                    evntHs.add(map.getValue());
                    config.put(et, evntHs);
                }
            }
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //返回该list的名字和该list中的最右边的元素
                List<String> events = jedisAdapter.brpop(0, "EventQueue");
                for (String event: events) {
                    if("EventQueue".equals(event)) {continue;}
                    EventModel eventModel = JSONObject.parseObject(event, EventModel.class);
                    if(!config.containsKey(eventModel.getEventType())){
                        logger.error("没有对该事件进行处理的Handler");
                        continue;
                    }
                    List<EventHandler> le = config.get(eventModel.getEventType());
                    for (EventHandler eventHandler: le) {
                        eventHandler.doHandle(eventModel);
                    }
                }
            }
        });

        t.start();
    }
}
