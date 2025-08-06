package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class HomePageData implements Serializable {
    public static final int FLAG_FIL = 0;
    public static final int FLAG_SUCC = 1;
    public static final int SHOW_DISPLAY = 1;
    public static final int SHOW_UNDISPLAY = 0;
    private List<HomePageBizData> access;
    private String hot;

    public List<HomePageBizData> getAccess() {
        return this.access;
    }

    public String getHot() {
        return this.hot;
    }

    public void setAccess(List<HomePageBizData> list) {
        this.access = list;
    }

    public void setHot(String str) {
        this.hot = str;
    }

    public String toString() {
        return "HomePageData{hot='" + this.hot + '\'' + ", access=" + this.access + '}';
    }
}
