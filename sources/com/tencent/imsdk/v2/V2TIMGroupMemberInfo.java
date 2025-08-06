package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;

public class V2TIMGroupMemberInfo implements Serializable {
    public GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
    public UserInfo userInfo;

    public String getFaceUrl() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getFaceUrl())) {
            return this.groupMemberInfo.getFaceUrl();
        }
        UserInfo userInfo2 = this.userInfo;
        return userInfo2 != null ? userInfo2.getFaceUrl() : "";
    }

    public String getFriendRemark() {
        return this.groupMemberInfo.getFriendRemark();
    }

    public GroupMemberInfo getGroupMemberInfo() {
        return this.groupMemberInfo;
    }

    public String getNameCard() {
        return this.groupMemberInfo.getNameCard();
    }

    public String getNickName() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getNickname())) {
            return this.groupMemberInfo.getNickname();
        }
        UserInfo userInfo2 = this.userInfo;
        return userInfo2 != null ? userInfo2.getNickname() : "";
    }

    public String getUserID() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getUserID())) {
            return this.groupMemberInfo.getUserID();
        }
        UserInfo userInfo2 = this.userInfo;
        return userInfo2 != null ? userInfo2.getUserID() : "";
    }

    public void setGroupMemberInfo(GroupMemberInfo groupMemberInfo2) {
        this.groupMemberInfo = groupMemberInfo2;
    }

    public void setUserInfo(UserInfo userInfo2) {
        this.userInfo = userInfo2;
    }

    public String toString() {
        return "V2TIMGroupMemberInfo--->" + "userID:" + getUserID() + ", nickName:" + getNickName() + ", nameCard:" + getNameCard() + ", friendRemark:" + getFriendRemark() + ", faceUrl:" + getFaceUrl();
    }
}
