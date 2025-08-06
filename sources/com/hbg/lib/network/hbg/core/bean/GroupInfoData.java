package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class GroupInfoData implements Serializable {
    private int alert;
    private int applyCount;
    private String avatar;
    private String groupId;

    /* renamed from: id  reason: collision with root package name */
    private int f70241id;
    private int isPresenter;
    private int liveId;
    private String notification;
    private String notification2;
    private int notification2Count;
    private int shareContract;
    private String title;
    private int type;
    private int userCount;

    public int getAlert() {
        return this.alert;
    }

    public int getApplyCount() {
        return this.applyCount;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getId() {
        return this.f70241id;
    }

    public int getIsPresenter() {
        return this.isPresenter;
    }

    public int getLiveId() {
        return this.liveId;
    }

    public String getNotification() {
        return this.notification;
    }

    public String getNotification2() {
        return this.notification2;
    }

    public int getNotification2Count() {
        return this.notification2Count;
    }

    public int getShareContract() {
        return this.shareContract;
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

    public void setAlert(int i11) {
        this.alert = i11;
    }

    public void setApplyCount(int i11) {
        this.applyCount = i11;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setId(int i11) {
        this.f70241id = i11;
    }

    public void setIsPresenter(int i11) {
        this.isPresenter = i11;
    }

    public void setLiveId(int i11) {
        this.liveId = i11;
    }

    public void setNotification(String str) {
        this.notification = str;
    }

    public void setNotification2(String str) {
        this.notification2 = str;
    }

    public void setNotification2Count(int i11) {
        this.notification2Count = i11;
    }

    public void setShareContract(int i11) {
        this.shareContract = i11;
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
