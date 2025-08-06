package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class CommunityUserPermissions implements Serializable {
    private static final long serialVersionUID = -3589753625731966272L;
    private String avatar;
    private int isComment;
    private int isLiveShare;
    private int isMute;
    private int isPublish;
    private int isSuper;
    private String publishRedirectUrl;
    private String publishTips;
    private String uidUnique;

    public String getAvatar() {
        return this.avatar;
    }

    public int getIsComment() {
        return this.isComment;
    }

    public int getIsLiveShare() {
        return this.isLiveShare;
    }

    public int getIsMute() {
        return this.isMute;
    }

    public int getIsPublish() {
        return this.isPublish;
    }

    public int getIsSuper() {
        return this.isSuper;
    }

    public String getPublishRedirectUrl() {
        return this.publishRedirectUrl;
    }

    public String getPublishTips() {
        return this.publishTips;
    }

    public String getUidUnique() {
        return this.uidUnique;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setIsComment(int i11) {
        this.isComment = i11;
    }

    public void setIsLiveShare(int i11) {
        this.isLiveShare = i11;
    }

    public void setIsMute(int i11) {
        this.isMute = i11;
    }

    public void setIsPublish(int i11) {
        this.isPublish = i11;
    }

    public void setIsSuper(int i11) {
        this.isSuper = i11;
    }

    public void setPublishRedirectUrl(String str) {
        this.publishRedirectUrl = str;
    }

    public void setPublishTips(String str) {
        this.publishTips = str;
    }

    public void setUidUnique(String str) {
        this.uidUnique = str;
    }
}
