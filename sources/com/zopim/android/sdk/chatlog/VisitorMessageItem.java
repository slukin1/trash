package com.zopim.android.sdk.chatlog;

import com.zopim.android.sdk.model.items.VisitorMessage;

final class VisitorMessageItem extends VisitorMessage implements LeadItem {
    private boolean leadItem;

    public VisitorMessageItem(VisitorMessage visitorMessage) {
        super.update(visitorMessage);
    }

    public boolean isLeadItem() {
        return this.leadItem;
    }

    public void setLeadItem(boolean z11) {
        this.leadItem = z11;
    }
}
