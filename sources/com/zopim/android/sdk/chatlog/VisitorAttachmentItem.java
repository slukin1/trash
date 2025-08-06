package com.zopim.android.sdk.chatlog;

import com.zopim.android.sdk.model.items.VisitorAttachment;

final class VisitorAttachmentItem extends VisitorAttachment implements LeadItem {
    private boolean leadItem;

    public VisitorAttachmentItem(VisitorAttachment visitorAttachment) {
        super.update(visitorAttachment);
    }

    public boolean isLeadItem() {
        return this.leadItem;
    }

    public void setLeadItem(boolean z11) {
        this.leadItem = z11;
    }
}
