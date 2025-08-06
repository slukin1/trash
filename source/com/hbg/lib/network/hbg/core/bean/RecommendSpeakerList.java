package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class RecommendSpeakerList extends LiveSquareBaseData {
    private List<RecommendSpeakerBean> listData;
    private int pageAll;
    private int pageNum;
    private int pageSize;
    private int total;

    public class RecommendSpeakerBean implements Serializable {
        private String account;
        private String avatar;
        private int fansNum;
        private int focusStatus;
        private int hasLive;
        private String liveId;
        private String nickname;
        private String uidUnique;

        public RecommendSpeakerBean() {
        }

        public String getAccount() {
            return this.account;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public int getFansNum() {
            return this.fansNum;
        }

        public int getFocusStatus() {
            return this.focusStatus;
        }

        public int getHasLive() {
            return this.hasLive;
        }

        public String getLiveId() {
            return this.liveId;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getUidUnique() {
            return this.uidUnique;
        }

        public void setAccount(String str) {
            this.account = str;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setFansNum(int i11) {
            this.fansNum = i11;
        }

        public void setFocusStatus(int i11) {
            this.focusStatus = i11;
        }

        public void setHasLive(int i11) {
            this.hasLive = i11;
        }

        public void setLiveId(String str) {
            this.liveId = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setUidUnique(String str) {
            this.uidUnique = str;
        }
    }

    public List<RecommendSpeakerBean> getListData() {
        return this.listData;
    }

    public int getPageAll() {
        return this.pageAll;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotal() {
        return this.total;
    }

    public void setListData(List<RecommendSpeakerBean> list) {
        this.listData = list;
    }

    public void setPageAll(int i11) {
        this.pageAll = i11;
    }

    public void setPageNum(int i11) {
        this.pageNum = i11;
    }

    public void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public void setTotal(int i11) {
        this.total = i11;
    }
}
