package com.huochat.community.model;

import java.io.Serializable;
import java.util.List;

public class TopicDetailBean implements Serializable {
    private List<CommunityItemBean> list;
    private int nextIndex;
    private int topicFlag;
    private int topicId;
    private String topicIntroduction;
    private String topicName;
    private String topicRecommend;

    public List<CommunityItemBean> getList() {
        return this.list;
    }

    public int getNextIndex() {
        return this.nextIndex;
    }

    public int getTopicFlag() {
        return this.topicFlag;
    }

    public int getTopicId() {
        return this.topicId;
    }

    public String getTopicIntroduction() {
        return this.topicIntroduction;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public String getTopicRecommend() {
        return this.topicRecommend;
    }

    public void setList(List<CommunityItemBean> list2) {
        this.list = list2;
    }

    public void setNextIndex(int i11) {
        this.nextIndex = i11;
    }

    public void setTopicFlag(int i11) {
        this.topicFlag = i11;
    }

    public void setTopicId(int i11) {
        this.topicId = i11;
    }

    public void setTopicIntroduction(String str) {
        this.topicIntroduction = str;
    }

    public void setTopicName(String str) {
        this.topicName = str;
    }

    public void setTopicRecommend(String str) {
        this.topicRecommend = str;
    }
}
