package com.zopim.android.sdk.chatlog;

import com.zopim.android.sdk.model.items.AgentAttachment;

final class AgentAttachmentItem extends AgentAttachment implements FirstItem, LeadItem {
    private boolean firstItem;
    private boolean leadItem;

    public AgentAttachmentItem(AgentAttachment agentAttachment) {
        super.update(agentAttachment);
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
