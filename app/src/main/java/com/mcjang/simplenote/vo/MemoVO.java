package com.mcjang.simplenote.vo;

import java.io.Serializable;

/**
 * Created by Minchang on 2015-07-01.
 */
public class MemoVO implements Serializable {

    private int id;

    private String subject;
    private String content;

    private boolean isRegistNotification;

    private String createdDate;
    private String modifiedDate;

    public MemoVO() {
        this.id = 0;
        this.subject = "";
        this.content = "";
        this.isRegistNotification = false;
        this.createdDate = "";
        this.modifiedDate = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRegistNotification() {
        return isRegistNotification;
    }

    public void setIsRegistNotification(boolean isRegistNotification) {
        this.isRegistNotification = isRegistNotification;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
