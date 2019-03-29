package com.meng.anjia.service;

import com.meng.anjia.dao.CommentDao;
import com.meng.anjia.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yue
 * @date  2019/3/18
 */
@Service
public class CommentService {
    @Autowired
    CommentDao commentDao;

    public List<Comment> getCommentsByEntity(int entityId, int entityType) {
        return commentDao.selectByEntity(entityId, entityType);
    }

    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    public int getCommentCount(int entityId, int entityType) {
        return commentDao.getCommentCount(entityId, entityType);
    }

    public void deleteComment(int entityId, int entityType) {
        commentDao.updateStatus(entityId, entityType, 1);
    }

    public Comment getCommentById(int id){
        return commentDao.getCommentById(id);
    }
}
