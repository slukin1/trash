package com.huochat.community.model;

import java.io.Serializable;

public class TopicBean implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private int f38699id;
    private String showTopicName;
    private String topicName;

    public int getId() {
        return this.f38699id;
    }

    public String getShowTopicName() {
        return this.showTopicName;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public void setId(int i11) {
        this.f38699id = i11;
    }

    public void setShowTopicName(String str) {
        this.showTopicName = str;
    }

    public void setTopicName(String str) {
        this.topicName = str;
    }
}
