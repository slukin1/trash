package com.tencent.imsdk.group;

import java.io.Serializable;

public class GroupInfoGetResult implements Serializable {
    private int errorCode;
    private String errorMessage;
    private String groupID;
    private GroupInfo groupInfo;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public void setErrorCode(int i11) {
        this.errorCode = i11;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setGroupInfo(GroupInfo groupInfo2) {
        this.groupInfo = groupInfo2;
    }
}
