package com.meng.anjia.controller;

import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.model.*;
import com.meng.anjia.service.*;
import com.meng.anjia.util.AnjiaUtil;
import com.meng.anjia.util.SolrAdapter;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * Created by yue on 2019/3/18
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    private static final int size = 5;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private FollowService followService;

    @Autowired
    SolrAdapter solrAdapter;
    /**
     * 提问 必须登陆才能提问
     * @param title 问题标题
     * @param content 问题描述
     * @return
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public String addQuestion(@RequestParam("title") String title, @RequestParam("content") String content) {
        try {
            Question question = new Question();
            question.setContent(content);
            question.setCreatedDate(new Date());
            question.setTitle(title);
            question.setUserId(hostHolder.getUser().getId());

            if (questionService.addQuestion(question) > 0) {
                return AnjiaUtil.getJSONString(0);
            }
        } catch (Exception e) {
            logger.error("增加题目失败" + e.getMessage());
        }
        return AnjiaUtil.getJSONString(1, "失败");
    }

    /**
     * 问题的详细信息
     * @return
     */
    @GetMapping(value = "/{qid}")
    public String questionDtail(@PathVariable("qid") int id, Model model){
        Question q = questionService.getById(id);
        model.addAttribute("question",q);
        List<ViewObject> vos = new LinkedList<>();
        //获取该用户是否关注该问题
        boolean isfollow = followService.isFollower(hostHolder.getUser().getId(), EntityType.ENTITY_QUESTION, id);
        int isf = isfollow ? 1 : 0;
        model.addAttribute("isfollow", isf);
        //1获取该问题的所有评论
        List<Comment> comments = commentService.getCommentsByEntity(id, EntityType.ENTITY_QUESTION);
        //2获取该评论的关注人数
        Long numOfFollower = followService.getFollowerCount(EntityType.ENTITY_QUESTION, id);
        model.addAttribute("numOfFollower", numOfFollower);
        //3 遍历评论comments 获取每一条评论的用户信息和点赞数 将其存到viewObject对象中
        for (Comment comment: comments) {
            long like = likeService.getLikeCount(EntityType.ENTITY_COMMENT, comment.getId());
            int likeStatus = likeService.getLikeStatus(hostHolder.getUser().getId(), EntityType.ENTITY_COMMENT,comment.getId());
            ViewObject vo = new ViewObject();
            User user = userService.getUser(comment.getUserId());
            vo.set("likeStatus", likeStatus);
            vo.set("like", like);
            vo.set("user", user);
            vo.set("comment", comment);
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        return "wenda/detail";
    }

    @GetMapping("/select/{q}/{offset}")
    public void select(@PathVariable String q, @PathVariable Integer offset, Model model) {
        try {
            QueryResponse queryResponse = solrAdapter.search("question",q,"title",offset * size,size);
            // 数量，分页用
            long total = queryResponse.getResults().getNumFound();
            List<Question> questions = queryResponse.getBeans(Question.class);
            model.addAttribute("q",q);
        }catch (Exception e){
            logger.error("发生错误" + e.getMessage());
        }
    }

}
