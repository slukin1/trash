package com.hbg.module.huobi.im.group.bean;

import java.io.Serializable;

public final class ImGroupChatItemBean implements Serializable {
    private String avatar = "";
    private String groupId = "";
    private int hasJion;
    private String title = "";
    private int type;
    private int userCount;

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getHasJion() {
        return this.hasJion;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setHasJion(int i11) {
        this.hasJion = i11;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setUserCount(int i11) {
        this.userCount = i11;
    }
}
