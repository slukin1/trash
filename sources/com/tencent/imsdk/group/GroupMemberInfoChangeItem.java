package com.tencent.imsdk.group;

import java.io.Serializable;

public class GroupMemberInfoChangeItem implements Serializable {
    private long shutUpTime;
    private String userID;

    public long getShutUpTime() {
        return this.shutUpTime;
    }

    public String getUserID() {
        return this.userID;
    }
}
