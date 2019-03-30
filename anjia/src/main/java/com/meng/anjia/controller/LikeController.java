package com.meng.anjia.controller;

import com.meng.anjia.async.EventModel;
import com.meng.anjia.async.EventProducer;
import com.meng.anjia.async.EventType;
import com.meng.anjia.model.Comment;
import com.meng.anjia.model.EntityType;
import com.meng.anjia.model.HostHolder;
import com.meng.anjia.service.CommentService;
import com.meng.anjia.service.LikeService;
import com.meng.anjia.util.AnjiaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yue
 * @date  2019/3/18
 */
@Controller
public class LikeController {
    @Autowired
    LikeService likeService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    CommentService commentService;

    @Autowired
    EventProducer eventProducer;

    @RequestMapping(path = {"/like"}, method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String like(@RequestParam("commentId") int commentId) {
        Comment comment = commentService.getCommentById(commentId);
        EventModel em = new EventModel();
        em.setEventType(EventType.LIKE);
        em.setEntityId(commentId);
        em.setEntityOwnerId(comment.getUserId());
        em.setEntityType(EntityType.ENTITY_COMMENT);
        em.setUserId(hostHolder.getUser().getId());
        eventProducer.fireEvent(em);
        long likeCount = likeService.like(hostHolder.getUser().getId(), EntityType.ENTITY_COMMENT, commentId);
        return AnjiaUtil.getJSONString(0, String.valueOf(likeCount));
    }

    @RequestMapping(path = {"/dislike"}, method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String dislike(@RequestParam("commentId") int commentId) {

        Comment comment = commentService.getCommentById(commentId);
        EventModel em = new EventModel();
        em.setEventType(EventType.DISLIKE);
        em.setEntityId(commentId);
        em.setEntityOwnerId(comment.getUserId());
        em.setEntityType(EntityType.ENTITY_COMMENT);
        em.setUserId(hostHolder.getUser().getId());
        eventProducer.fireEvent(em);
        long likeCount = likeService.disLike(hostHolder.getUser().getId(), EntityType.ENTITY_COMMENT, commentId);
        return AnjiaUtil.getJSONString(0, String.valueOf(likeCount));
    }
}
