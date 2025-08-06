package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LiveBannerData implements Serializable {
    private String imgUrl;
    private int languageId;
    private String liveId;
    private String url;

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getLanguageId() {
        return this.languageId;
    }

    public String getLiveId() {
        return this.liveId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setLanguageId(int i11) {
        this.languageId = i11;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
