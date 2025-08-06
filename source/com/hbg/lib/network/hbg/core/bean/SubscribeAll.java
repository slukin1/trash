package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SubscribeAll {
    @SerializedName("imgUrl")
    private Object imgUrl;
    @SerializedName("list")
    private List<ListBean> list;
    @SerializedName("redirect")
    private Object redirect;
    @SerializedName("sort")
    private Object sort;
    @SerializedName("title")
    private String title;

    public static class ListBean {
        @SerializedName("aboutToBegin")
        private String aboutToBegin;
        @SerializedName("countDown")
        private long countDown;
        @SerializedName("name")
        private String name;
        @SerializedName("title")
        private String title;
        @SerializedName("titleMd")
        private String titleMd;
        @SerializedName("type")
        private int type;
        @SerializedName("url")
        private String url;

        public String getAboutToBegin() {
            return this.aboutToBegin;
        }

        public long getCountDown() {
            return this.countDown;
        }

        public String getName() {
            return this.name;
        }

        public String getTitle() {
            return this.title;
        }

        public String getTitleMd() {
            return this.titleMd;
        }

        public int getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public void setAboutToBegin(String str) {
            this.aboutToBegin = str;
        }

        public void setCountDown(long j11) {
            this.countDown = j11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTitleMd(String str) {
            this.titleMd = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public Object getImgUrl() {
        return this.imgUrl;
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public Object getRedirect() {
        return this.redirect;
    }

    public Object getSort() {
        return this.sort;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImgUrl(Object obj) {
        this.imgUrl = obj;
    }

    public void setList(List<ListBean> list2) {
        this.list = list2;
    }

    public void setRedirect(Object obj) {
        this.redirect = obj;
    }

    public void setSort(Object obj) {
        this.sort = obj;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
