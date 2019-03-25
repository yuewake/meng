package com.meng.anjia.service;

import com.meng.anjia.dao.QuestionDao;
import com.meng.anjia.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * Created by yue on 2019/3/18
 */
@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public Question getById(int id) {
        return questionDao.getById(id);
    }

    public int addQuestion(Question question) {
        question.setTitle(HtmlUtils.htmlEscape(question.getTitle()));
        question.setContent(HtmlUtils.htmlEscape(question.getContent()));
        int num = questionDao.addQuestion(question);
        return num > 0 ? question.getId() : 0;
    }

    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDao.selectLatestQuestions(userId, offset, limit);
    }

    public int updateCommentCount(int id, int count) {
        return questionDao.updateCommentCount(id, count);
    }
}
