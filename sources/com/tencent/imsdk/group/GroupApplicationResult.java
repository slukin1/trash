package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.List;

public class GroupApplicationResult implements Serializable {
    private List<GroupApplication> groupApplicationList;
    private long unreadCount;

    public List<GroupApplication> getGroupApplicationList() {
        return this.groupApplicationList;
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public void setUnreadCount(long j11) {
        this.unreadCount = j11;
    }
}
