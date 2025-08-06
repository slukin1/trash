package com.tencent.imsdk.group;

import java.io.Serializable;

public class GroupInfoModifyParam implements Serializable {
    private GroupInfo groupInfo;
    private long modifyFlag;

    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public long getModifyFlag() {
        return this.modifyFlag;
    }

    public void setGroupInfo(GroupInfo groupInfo2) {
        this.groupInfo = groupInfo2;
    }

    public void setModifyFlag(long j11) {
        this.modifyFlag = j11;
    }
}
