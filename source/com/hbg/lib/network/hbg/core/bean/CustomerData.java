package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CustomerData {
    @SerializedName("feedback")
    private String feedback;

    /* renamed from: id  reason: collision with root package name */
    private String f70234id;
    @SerializedName("imgUrl")
    private String imgUrl;
    private boolean isDnd;
    @SerializedName("list")
    private List<ListBean> list;
    @SerializedName("name")
    private String name;
    @SerializedName("nameDesc")
    private String nameDesc;
    @SerializedName("title")
    private String title;
    @SerializedName("titleMd")
    private String titleMd;
    @SerializedName("url")
    private String url;

    public static class ListBean {
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        public String getName() {
            return this.name;
        }

        public String getUrl() {
            return this.url;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public String getBusinessCategory() {
        if (!TextUtils.isEmpty(this.titleMd)) {
            return this.titleMd;
        }
        return this.title;
    }

    public String getFeedback() {
        return this.feedback;
    }

    public String getId() {
        return this.f70234id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public String getName() {
        return this.name;
    }

    public String getNameDesc() {
        return this.nameDesc;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleMd() {
        return this.titleMd;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isDnd() {
        return this.isDnd;
    }

    public void setFeedback(String str) {
        this.feedback = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setList(List<ListBean> list2) {
        this.list = list2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNameDesc(String str) {
        this.nameDesc = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitleMd(String str) {
        this.titleMd = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
