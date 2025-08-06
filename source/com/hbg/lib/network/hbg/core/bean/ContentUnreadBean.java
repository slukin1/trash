package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ContentUnreadBean implements Serializable {
    private int communityNum;
    private ContentNewsUnreadBean news;

    public int getCommunityNum() {
        return this.communityNum;
    }

    public ContentNewsUnreadBean getNews() {
        return this.news;
    }

    public void setCommunityNum(int i11) {
        this.communityNum = i11;
    }

    public void setNews(ContentNewsUnreadBean contentNewsUnreadBean) {
        this.news = contentNewsUnreadBean;
    }
}
