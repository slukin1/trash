package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LiveCategoryData implements Serializable {
    private int categoryId;
    private String logo;
    private String title;

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCategoryId(int i11) {
        this.categoryId = i11;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
