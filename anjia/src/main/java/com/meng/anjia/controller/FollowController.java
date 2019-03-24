package com.meng.anjia.controller;

import com.meng.anjia.model.EntityType;
import com.meng.anjia.model.HostHolder;
import com.meng.anjia.service.CommentService;
import com.meng.anjia.service.FollowService;
import com.meng.anjia.service.QuestionService;
import com.meng.anjia.service.UserService;
import com.meng.anjia.util.AnjiaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yue on 2019/3/18
 */
@Controller
public class FollowController {
    private static final Logger logger = LoggerFactory.getLogger(FollowController.class);

    @Autowired
    FollowService followService;

    @Autowired
    CommentService commentService;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;

    @RequestMapping("/followQuestion")
    @ResponseBody
    public String followQuestion(int questionId){
        try {
            boolean isSuccess = followService.follow(hostHolder.getUser().getId(), EntityType.ENTITY_QUESTION, questionId);
            //关注该问题的人数
            String msg = followService.getFollowerCount(EntityType.ENTITY_QUESTION, questionId) + "";
            if(isSuccess){
                return AnjiaUtil.getJSONString(1,msg);
                //TODO 关注成功后 需要通知问题的发布者 使用异步队列
            }else{
                return AnjiaUtil.getJSONString(0);
            }
        }catch (Exception e){
            logger.error("出现异常："+e.getMessage());
            return AnjiaUtil.getJSONString(0);
        }

    }

    @RequestMapping("/unfollowQuestion")
    @ResponseBody
    public String unfollowQuestion(int questionId){
        try{
            boolean isSuccess = followService.unfollow(hostHolder.getUser().getId(),EntityType.ENTITY_QUESTION, questionId);
            String msg = followService.getFollowerCount(EntityType.ENTITY_QUESTION, questionId) + "";
            if(isSuccess){
                return AnjiaUtil.getJSONString(1,msg);
                //TODO 取消需要通知问题的发布者 使用异步队列
            }else{
                return AnjiaUtil.getJSONString(0);
            }
        }catch (Exception e){
            logger.error("出现异常：" + e.getMessage());
            return AnjiaUtil.getJSONString(0);
        }
    }
}
