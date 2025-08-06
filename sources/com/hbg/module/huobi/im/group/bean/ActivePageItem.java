package com.hbg.module.huobi.im.group.bean;

import java.io.Serializable;

public class ActivePageItem implements Serializable {
    private String className;
    private boolean isViewCreate;

    public String getClassName() {
        return this.className;
    }

    public boolean isViewCreate() {
        return this.isViewCreate;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setViewCreate(boolean z11) {
        this.isViewCreate = z11;
    }
}
