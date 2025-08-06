package com.tencent.imsdk.relationship;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FriendInfo implements Serializable {
    private String addSource;
    private long addTime;
    private String addWording;
    private HashMap<String, byte[]> friendCustomInfo = new HashMap<>();
    private List<String> friendGroups = new ArrayList();
    private int relationType;
    private String remark;
    private UserInfo userInfo = new UserInfo();

    public void addFriendCustomInfo(String str, byte[] bArr) {
        this.friendCustomInfo.put(str, bArr);
    }

    public void addFriendGroup(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.friendGroups.add(str);
        }
    }

    public String getAddSource() {
        return this.addSource;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public String getAddWording() {
        return this.addWording;
    }

    public HashMap<String, byte[]> getFriendCustomInfo() {
        return this.friendCustomInfo;
    }

    public List<String> getFriendGroups() {
        return this.friendGroups;
    }

    public int getRelationType() {
        return this.relationType;
    }

    public String getRemark() {
        return this.remark;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setAddSource(String str) {
        this.addSource = str;
    }

    public void setAddTime(long j11) {
        this.addTime = j11;
    }

    public void setAddWording(String str) {
        this.addWording = str;
    }

    public void setRelationType(int i11) {
        this.relationType = i11;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setUserInfo(UserInfo userInfo2) {
        this.userInfo = userInfo2;
    }
}
