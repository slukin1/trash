package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class TranslateBean implements Serializable {
    private String content;
    private String title;

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
