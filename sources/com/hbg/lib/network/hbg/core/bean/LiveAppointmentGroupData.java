package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LiveAppointmentGroupData implements Serializable {
    private String avatar;
    private long createTime;
    private String groupId;
    private int hasJion;

    /* renamed from: id  reason: collision with root package name */
    private long f70248id;
    private long liveId;
    private String title;
    private int type;
    private int userCount;

    public String getAvatar() {
        return this.avatar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getHasJion() {
        return this.hasJion;
    }

    public long getId() {
        return this.f70248id;
    }

    public long getLiveId() {
        return this.liveId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setCreateTime(long j11) {
        this.createTime = j11;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setHasJion(int i11) {
        this.hasJion = i11;
    }

    public void setId(long j11) {
        this.f70248id = j11;
    }

    public void setLiveId(long j11) {
        this.liveId = j11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUserCount(int i11) {
        this.userCount = i11;
    }
}
