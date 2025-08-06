package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class V2TIMConversationResult implements Serializable {
    private ConversationResult conversationResult;

    public List<V2TIMConversation> getConversationList() {
        if (this.conversationResult == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Conversation conversation : this.conversationResult.getConversationList()) {
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setConversation(conversation);
            arrayList.add(v2TIMConversation);
        }
        return arrayList;
    }

    public long getNextSeq() {
        ConversationResult conversationResult2 = this.conversationResult;
        if (conversationResult2 != null) {
            return conversationResult2.getNextSeq();
        }
        return 0;
    }

    public boolean isFinished() {
        ConversationResult conversationResult2 = this.conversationResult;
        if (conversationResult2 != null) {
            return conversationResult2.isFinish();
        }
        return false;
    }

    public void setConversationResult(ConversationResult conversationResult2) {
        this.conversationResult = conversationResult2;
    }
}
