package com.tencent.qcloud.tuikit.timcommon.bean;

import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import java.io.Serializable;

public class MessageReceiptInfo implements Serializable {
    private V2TIMMessageReceipt messageReceipt;

    public String getGroupID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getGroupID();
        }
        return null;
    }

    public String getMsgID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getMsgID();
        }
        return null;
    }

    public long getReadCount() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getReadCount();
        }
        return 0;
    }

    public long getTimestamp() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getTimestamp();
        }
        return 0;
    }

    public long getUnreadCount() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getUnreadCount();
        }
        return 0;
    }

    public String getUserID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getUserID();
        }
        return null;
    }

    public boolean isPeerRead() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.isPeerRead();
        }
        return false;
    }

    public void setMessageReceipt(V2TIMMessageReceipt v2TIMMessageReceipt) {
        this.messageReceipt = v2TIMMessageReceipt;
    }
}
