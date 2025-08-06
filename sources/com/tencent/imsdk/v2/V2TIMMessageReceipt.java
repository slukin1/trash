package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.C2CMessageReceipt;
import com.tencent.imsdk.message.GroupMessageReceipt;
import java.io.Serializable;

public class V2TIMMessageReceipt implements Serializable {
    private C2CMessageReceipt c2cMessageReceipt;
    private GroupMessageReceipt groupMessageReceipt;

    public String getGroupID() {
        GroupMessageReceipt groupMessageReceipt2 = this.groupMessageReceipt;
        return groupMessageReceipt2 != null ? groupMessageReceipt2.getGroupID() : "";
    }

    public String getMsgID() {
        C2CMessageReceipt c2CMessageReceipt = this.c2cMessageReceipt;
        if (c2CMessageReceipt != null) {
            return c2CMessageReceipt.getMessageID();
        }
        GroupMessageReceipt groupMessageReceipt2 = this.groupMessageReceipt;
        return groupMessageReceipt2 != null ? groupMessageReceipt2.getMsgID() : "";
    }

    public long getReadCount() {
        GroupMessageReceipt groupMessageReceipt2 = this.groupMessageReceipt;
        if (groupMessageReceipt2 != null) {
            return groupMessageReceipt2.getReadCount();
        }
        return 0;
    }

    public long getTimestamp() {
        C2CMessageReceipt c2CMessageReceipt = this.c2cMessageReceipt;
        if (c2CMessageReceipt != null) {
            return c2CMessageReceipt.getReceiptTimestamp();
        }
        return 0;
    }

    public long getUnreadCount() {
        GroupMessageReceipt groupMessageReceipt2 = this.groupMessageReceipt;
        if (groupMessageReceipt2 != null) {
            return groupMessageReceipt2.getUnreadCount();
        }
        return 0;
    }

    public String getUserID() {
        C2CMessageReceipt c2CMessageReceipt = this.c2cMessageReceipt;
        if (c2CMessageReceipt != null) {
            return c2CMessageReceipt.getUserID();
        }
        return null;
    }

    public boolean isPeerRead() {
        C2CMessageReceipt c2CMessageReceipt = this.c2cMessageReceipt;
        if (c2CMessageReceipt != null) {
            return c2CMessageReceipt.isPeerRead();
        }
        return false;
    }

    public void setC2CMessageReceipt(C2CMessageReceipt c2CMessageReceipt) {
        this.c2cMessageReceipt = c2CMessageReceipt;
    }

    public void setGroupMessageReceipt(GroupMessageReceipt groupMessageReceipt2) {
        this.groupMessageReceipt = groupMessageReceipt2;
    }
}
