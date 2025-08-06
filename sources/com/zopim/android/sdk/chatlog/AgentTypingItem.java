package com.zopim.android.sdk.chatlog;

import com.zopim.android.sdk.model.items.AgentTyping;

final class AgentTypingItem extends AgentTyping implements LeadItem {
    private boolean leadItem;

    public AgentTypingItem(AgentTyping agentTyping) {
        super.update(agentTyping);
    }

    public boolean isLeadItem() {
        return this.leadItem;
    }

    public void setLeadItem(boolean z11) {
        this.leadItem = z11;
    }
}
