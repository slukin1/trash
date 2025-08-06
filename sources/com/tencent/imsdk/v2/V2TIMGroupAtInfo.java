package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.ConversationAtInfo;
import java.io.Serializable;

public class V2TIMGroupAtInfo implements Serializable {
    public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
    public static final int TIM_AT_ALL = 2;
    public static final int TIM_AT_ALL_AT_ME = 3;
    public static final int TIM_AT_ME = 1;
    public static final int TIM_AT_UNKNOWN = 0;
    private ConversationAtInfo conversationAtInfo;

    public int getAtType() {
        ConversationAtInfo conversationAtInfo2 = this.conversationAtInfo;
        if (conversationAtInfo2 == null) {
            return 0;
        }
        return conversationAtInfo2.getAtType();
    }

    public long getSeq() {
        ConversationAtInfo conversationAtInfo2 = this.conversationAtInfo;
        if (conversationAtInfo2 == null) {
            return -1;
        }
        return conversationAtInfo2.getAtMessageSequence();
    }

    public void setConversationGroupAtInfo(ConversationAtInfo conversationAtInfo2) {
        this.conversationAtInfo = conversationAtInfo2;
    }
}
