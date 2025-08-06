package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;

public class CommunityData {
    @SerializedName("dynamicNum")
    private String dynamicNum;
    @SerializedName("fansNum")
    private String fansNum;
    @SerializedName("focusNum")
    private String focusNum;
    @SerializedName("likesNum")
    private String likesNum;

    public String getDynamicNum() {
        return this.dynamicNum;
    }

    public String getFansNum() {
        return this.fansNum;
    }

    public String getFocusNum() {
        return this.focusNum;
    }

    public String getLikesNum() {
        return this.likesNum;
    }

    public void setDynamicNum(String str) {
        this.dynamicNum = str;
    }

    public void setFansNum(String str) {
        this.fansNum = str;
    }

    public void setFocusNum(String str) {
        this.focusNum = str;
    }

    public void setLikesNum(String str) {
        this.likesNum = str;
    }
}
