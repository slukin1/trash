package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;

public class ChatEvent extends RowItem<ChatEvent> {
    private String message;

    public ChatEvent() {
        super.setType(RowItem.Type.CHAT_EVENT);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatEvent) || !super.equals(obj)) {
            return false;
        }
        String str = this.message;
        String str2 = ((ChatEvent) obj).message;
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
        return "event: " + this.message + super.toString();
    }

    public void update(ChatEvent chatEvent) {
        super.update(chatEvent);
        this.message = chatEvent.message;
    }
}
