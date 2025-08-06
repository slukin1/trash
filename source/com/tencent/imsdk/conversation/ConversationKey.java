package com.tencent.imsdk.conversation;

import java.io.Serializable;

public class ConversationKey implements Serializable {
    public static final int TYPE_C2C = 1;
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_SYSTEM = 3;
    public static final int TYPE_UNKNOWN = 0;
    private String conversationID;
    private int conversationType;

    public String getConversationID() {
        return this.conversationID;
    }

    public int getConversationType() {
        return this.conversationType;
    }

    public void setConversationID(String str) {
        this.conversationID = str;
    }

    public void setConversationType(int i11) {
        this.conversationType = i11;
    }
}
