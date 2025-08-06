package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ContentNewsUnreadBean implements Serializable {
    private int newsNum;
    private int newsflashNum;

    public int getNewsNum() {
        return this.newsNum;
    }

    public int getNewsflashNum() {
        return this.newsflashNum;
    }

    public void setNewsNum(int i11) {
        this.newsNum = i11;
    }

    public void setNewsflashNum(int i11) {
        this.newsflashNum = i11;
    }
}
