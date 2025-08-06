package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class SubscribeBox implements Serializable {
    @SerializedName("mySubscribe")
    private MySubscribeBean mySubscribe;
    @SerializedName("myToolResp")
    private MyToolRespBean myToolResp;

    public static class ListBean implements Serializable {
        @SerializedName("aboutToBegin")
        private String aboutToBegin;
        @SerializedName("countDown")
        private long countDown;
        private int infoSum;
        @SerializedName("name")
        private String name;
        private String redDot;
        @SerializedName("title")
        private String title;
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

        public int getInfoSum() {
            return this.infoSum;
        }

        public String getName() {
            return this.name;
        }

        public String getRedDot() {
            return this.redDot;
        }

        public String getTitle() {
            return this.title;
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

        public void setInfoSum(int i11) {
            this.infoSum = i11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setRedDot(String str) {
            this.redDot = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public static class MySubscribeBean implements Serializable {
        @SerializedName("imgUrl")
        private String imgUrl;
        @SerializedName("infoSum")
        private int infoSum;
        @SerializedName("list")
        private List<ListBean> list;
        @SerializedName("redirect")
        private String redirect;
        @SerializedName("sort")
        private int sort;
        @SerializedName("title")
        private String title;
        @SerializedName("titleMd")
        private String titleMd;

        public String getBusinessCategory() {
            if (!TextUtils.isEmpty(this.titleMd)) {
                return this.titleMd;
            }
            return this.title;
        }

        public String getImgUrl() {
            return this.imgUrl;
        }

        public int getInfoSum() {
            return this.infoSum;
        }

        public List<ListBean> getList() {
            return this.list;
        }

        public String getRedirect() {
            return this.redirect;
        }

        public int getSort() {
            return this.sort;
        }

        public String getTitle() {
            return this.title;
        }

        public String getTitleMd() {
            return this.titleMd;
        }

        public void setImgUrl(String str) {
            this.imgUrl = str;
        }

        public void setInfoSum(int i11) {
            this.infoSum = i11;
        }

        public void setList(List<ListBean> list2) {
            this.list = list2;
        }

        public void setRedirect(String str) {
            this.redirect = str;
        }

        public void setSort(int i11) {
            this.sort = i11;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTitleMd(String str) {
            this.titleMd = str;
        }
    }

    public static class MyToolRespBean implements Serializable {
        @SerializedName("imgUrl")
        private String imgUrl;
        @SerializedName("list")
        private List<ToolBean> list;
        @SerializedName("redirect")
        private String redirect;
        @SerializedName("sort")
        private int sort;
        @SerializedName("title")
        private String title;

        public String getImgUrl() {
            return this.imgUrl;
        }

        public List<ToolBean> getList() {
            return this.list;
        }

        public Object getRedirect() {
            return this.redirect;
        }

        public int getSort() {
            return this.sort;
        }

        public String getTitle() {
            return this.title;
        }

        public void setImgUrl(String str) {
            this.imgUrl = str;
        }

        public void setList(List<ToolBean> list2) {
            this.list = list2;
        }

        public void setRedirect(String str) {
            this.redirect = str;
        }

        public void setSort(int i11) {
            this.sort = i11;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public static class ToolBean implements Serializable {
        @SerializedName("imgNightUrl")
        private String imgNightUrl;
        @SerializedName("imgUrl")
        private String imgUrl;
        @SerializedName("jumpUrl")
        private String jumpUrl;
        @SerializedName("title")
        private String title;
        @SerializedName("titleMd")
        private String titleMd;

        public String getImgNightUrl() {
            return this.imgNightUrl;
        }

        public String getImgUrl() {
            return this.imgUrl;
        }

        public String getJumpUrl() {
            return this.jumpUrl;
        }

        public String getTitle() {
            return this.title;
        }

        public String getTitleMd() {
            return this.titleMd;
        }

        public void setImgNightUrl(String str) {
            this.imgNightUrl = str;
        }

        public void setImgUrl(String str) {
            this.imgUrl = str;
        }

        public void setJumpUrl(String str) {
            this.jumpUrl = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTitleMd(String str) {
            this.titleMd = str;
        }
    }

    public MySubscribeBean getMySubscribe() {
        return this.mySubscribe;
    }

    public MyToolRespBean getMyToolResp() {
        return this.myToolResp;
    }

    public void setMySubscribe(MySubscribeBean mySubscribeBean) {
        this.mySubscribe = mySubscribeBean;
    }

    public void setMyToolResp(MyToolRespBean myToolRespBean) {
        this.myToolResp = myToolRespBean;
    }
}
