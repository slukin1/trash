package com.tencent.imsdk.conversation;

import java.io.Serializable;

public class ConversationOperationResult implements Serializable {
    private String conversationID;
    private int resultCode;
    private String resultInfo;

    public String getConversationID() {
        return this.conversationID;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }
}
