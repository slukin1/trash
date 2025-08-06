package com.tencent.imsdk.message;

import java.io.Serializable;

public class GroupMessageReceipt implements Serializable {
    private String groupID;
    private String msgID;
    private long readCount;
    private long unreadCount;

    public String getGroupID() {
        return this.groupID;
    }

    public String getMsgID() {
        return this.msgID;
    }

    public long getReadCount() {
        return this.readCount;
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setMsgID(String str) {
        this.msgID = str;
    }

    public void setReadCount(long j11) {
        this.readCount = j11;
    }

    public void setUnreadCount(long j11) {
        this.unreadCount = j11;
    }
}
