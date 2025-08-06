package com.tencent.imsdk.conversation;

import java.io.Serializable;

public class UnreadMessageCountResult implements Serializable {
    private ConversationListFilter filter = new ConversationListFilter();
    private long totalUnreadCount = 0;

    public ConversationListFilter getFilter() {
        return this.filter;
    }

    public long getTotalUnreadCount() {
        return this.totalUnreadCount;
    }

    public void setTotalUnreadCount(long j11) {
        this.totalUnreadCount = j11;
    }
}
