package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.List;

public class GroupMemberInfoResult implements Serializable {
    private List<GroupMemberInfo> groupMemberInfoList;
    private long nextSeq;

    public List<GroupMemberInfo> getGroupMemberInfoList() {
        return this.groupMemberInfoList;
    }

    public long getNextSeq() {
        return this.nextSeq;
    }

    public void setGroupMemberInfoList(List<GroupMemberInfo> list) {
        this.groupMemberInfoList = list;
    }

    public void setNextSeq(long j11) {
        this.nextSeq = j11;
    }
}
