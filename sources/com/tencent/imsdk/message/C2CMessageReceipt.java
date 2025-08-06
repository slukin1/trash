package com.tencent.imsdk.message;

import java.io.Serializable;

public class C2CMessageReceipt implements Serializable {
    private boolean isPeerRead;
    private String messageID;
    private long receiptTimestamp;
    private String userID;

    public String getMessageID() {
        return this.messageID;
    }

    public long getReceiptTimestamp() {
        return this.receiptTimestamp;
    }

    public String getUserID() {
        return this.userID;
    }

    public boolean isPeerRead() {
        return this.isPeerRead;
    }

    public void setMessageID(String str) {
        this.messageID = str;
    }

    public void setPeerRead(boolean z11) {
        this.isPeerRead = z11;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
