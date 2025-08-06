package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.ConversationOperationResult;
import java.io.Serializable;

public class V2TIMConversationOperationResult implements Serializable {
    private ConversationOperationResult operationResult;

    public String getConversationID() {
        ConversationOperationResult conversationOperationResult = this.operationResult;
        if (conversationOperationResult != null) {
            return conversationOperationResult.getConversationID();
        }
        return null;
    }

    public int getResultCode() {
        ConversationOperationResult conversationOperationResult = this.operationResult;
        if (conversationOperationResult != null) {
            return conversationOperationResult.getResultCode();
        }
        return 0;
    }

    public String getResultInfo() {
        ConversationOperationResult conversationOperationResult = this.operationResult;
        if (conversationOperationResult != null) {
            return conversationOperationResult.getResultInfo();
        }
        return null;
    }

    public void setConversationOperationResult(ConversationOperationResult conversationOperationResult) {
        this.operationResult = conversationOperationResult;
    }
}
