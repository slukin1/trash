package com.zopim.android.sdk.chatlog;

import com.zopim.android.sdk.model.items.AgentMessage;

final class AgentMessageItem extends AgentMessage implements FirstItem, LeadItem {
    private boolean firstItem;
    private boolean leadItem;

    public AgentMessageItem(AgentMessage agentMessage) {
        super.update(agentMessage);
    }

    public boolean isFirstItem() {
        return this.firstItem;
    }

    public boolean isLeadItem() {
        return this.leadItem;
    }

    public void setFirstItem(boolean z11) {
        this.firstItem = z11;
    }

    public void setLeadItem(boolean z11) {
        this.leadItem = z11;
    }
}
