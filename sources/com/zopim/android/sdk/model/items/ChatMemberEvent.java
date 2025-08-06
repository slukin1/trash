package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;

public class ChatMemberEvent extends RowItem<ChatMemberEvent> {
    private String message;

    public ChatMemberEvent() {
        super.setType(RowItem.Type.MEMBER_EVENT);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMemberEvent) || !super.equals(obj)) {
            return false;
        }
        String str = this.message;
        String str2 = ((ChatMemberEvent) obj).message;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        String str = this.message;
        return str != null ? str : "";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.message;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return super.toString() + " event: " + this.message;
    }

    public void update(ChatMemberEvent chatMemberEvent) {
        super.update(chatMemberEvent);
        this.message = chatMemberEvent.message;
    }
}
