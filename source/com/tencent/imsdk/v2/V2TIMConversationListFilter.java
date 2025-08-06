package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.ConversationListFilter;
import java.io.Serializable;

public class V2TIMConversationListFilter implements Serializable {
    private ConversationListFilter filter = new ConversationListFilter();

    public ConversationListFilter getConversationFilter() {
        return this.filter;
    }

    public String getConversationGroup() {
        ConversationListFilter conversationListFilter = this.filter;
        return conversationListFilter != null ? conversationListFilter.getConversationGroup() : "";
    }

    public int getConversationType() {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            return conversationListFilter.getConversationType();
        }
        return 0;
    }

    public long getMarkType() {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            return conversationListFilter.getMarkType();
        }
        return 0;
    }

    public void setConversationFilter(ConversationListFilter conversationListFilter) {
        this.filter = conversationListFilter;
    }

    public void setConversationGroup(String str) {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            conversationListFilter.setConversationGroup(str);
        }
    }

    public void setConversationType(int i11) {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            conversationListFilter.setConversationType(i11);
        }
    }

    public void setMarkType(long j11) {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            conversationListFilter.setMarkType(j11);
        }
    }
}
