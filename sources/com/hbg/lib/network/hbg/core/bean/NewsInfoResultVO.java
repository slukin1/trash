package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class NewsInfoResultVO implements Serializable {
    private static final long serialVersionUID = -6072784925761163133L;
    private String button;
    private String icon;
    private String isShow;
    private String text;
    private String textId;
    private String url;

    public String getButton() {
        return this.button;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIsShow() {
        return this.isShow;
    }

    public String getText() {
        return this.text;
    }

    public String getTextId() {
        return this.textId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIsShow(String str) {
        this.isShow = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTextId(String str) {
        this.textId = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
