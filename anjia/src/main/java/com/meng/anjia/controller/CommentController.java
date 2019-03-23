package com.meng.anjia.controller;

import com.meng.anjia.model.Comment;
import com.meng.anjia.model.EntityType;
import com.meng.anjia.model.HostHolder;
import com.meng.anjia.service.CommentService;
import com.meng.anjia.service.QuestionService;
import com.meng.anjia.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

/**
 * Created by yue on 2019/3/18
 */
@Controller
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    HostHolder hostHolder;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @Autowired
    QuestionService questionService;

    @RequestMapping(path = "/addComment",method={RequestMethod.POST})
    public String addComment(@RequestParam("entityId") int entityId,
                             @RequestParam("content") String content,
                             @RequestParam("entityType") int entityType) {
        try {
            content = HtmlUtils.htmlEscape(content);
            //TODO 敏感词过滤

            Comment comment = new Comment();
            comment.setContent(content);
            comment.setEntityId(entityId);
            comment.setEntityType(entityType);
            comment.setCreatedDate(new Date());
            comment.setStatus(0);
            comment.setUserId(hostHolder.getUser().getId());
            commentService.addComment(comment);
            // 更新题目里的评论数量
            if (entityType == 1) {
                int count = commentService.getCommentCount(comment.getEntityId(), comment.getEntityType());
                questionService.updateCommentCount(comment.getEntityId(), count);
            }

        } catch (Exception e) {
            logger.error("增加失败" + e.getMessage());
        }
        if(entityType == 1) {
            return "redirect:/question/" + String.valueOf(entityId);
        }else{
            return "redirect:/buildingInformation/" + String.valueOf(entityId);
        }

    }
}
