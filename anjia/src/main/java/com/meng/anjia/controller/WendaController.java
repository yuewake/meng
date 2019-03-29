package com.meng.anjia.controller;

import com.meng.anjia.model.Question;
import com.meng.anjia.model.ViewObject;
import com.meng.anjia.service.QuestionService;
import com.meng.anjia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yue on 2019/3/18
 */
@Controller
public class WendaController {

    private static final int size = 5;

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    /**
     * 根据userId 获取某userId提出的问题（目前获取方式是 问题按时间排序 取前几）
     * 如果userId为0 那么获取所有问题(这里先默认为0)
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    private List<ViewObject> getQuestions(int userId, int offset, int limit) {
        List<Question> questionList = questionService.getLatestQuestions(userId, offset, limit);
        List<ViewObject> vos = new ArrayList<>();
        for (Question question : questionList) {

            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("user", userService.getUser(question.getUserId()));
            vos.add(vo);
        }
        return vos;
    }

    @RequestMapping("/wenda")
    public String index(Model model,int offset){
        model.addAttribute("vos", getQuestions(0, offset * size, size));
        int total = questionService.getCountOfQuestion(0);
        if(total % size == 0) {
            total = total / size;
        } else {
            total = (total / size) + 1;
        }
        model.addAttribute("total",total);
        model.addAttribute("offset",offset);
        return "wenda/index";
    }
}
