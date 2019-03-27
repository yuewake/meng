package com.meng.anjia.model;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * Created by yue on 2019/3/18
 */


public class Question {

    @Field(value = "id")
    private int id;
    @Field(value = "title")
    private String title;
    @Field(value = "content")
    private String content;

    private Date createdDate;

    private int userId;

    private int commentCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", userId=" + userId +
                ", commentCount=" + commentCount +
                '}';
    }
}
