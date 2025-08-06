package com.tencent.qcloud.tuikit.timcommon.bean;

import android.text.TextUtils;
import java.io.Serializable;

public class ReactUserBean implements Serializable {
    private String faceUrl;
    private String friendRemark;
    private String nameCard;
    private String nikeName;
    private String userId;

    public String getDisplayString() {
        if (!TextUtils.isEmpty(this.nameCard)) {
            return this.nameCard;
        }
        if (!TextUtils.isEmpty(this.friendRemark)) {
            return this.friendRemark;
        }
        if (!TextUtils.isEmpty(this.nikeName)) {
            return this.nikeName;
        }
        return this.userId;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getFriendRemark() {
        return this.friendRemark;
    }

    public String getNameCard() {
        return this.nameCard;
    }

    public String getNikeName() {
        return this.nikeName;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setFriendRemark(String str) {
        this.friendRemark = str;
    }

    public void setNameCard(String str) {
        this.nameCard = str;
    }

    public void setNikeName(String str) {
        this.nikeName = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
