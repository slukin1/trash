package com.hbg.event;

import com.huobi.otc.bean.OtcChatContent;
import java.io.Serializable;

public class ChatReSendEvent implements Serializable {
    private OtcChatContent otcChatContent;

    public boolean canEqual(Object obj) {
        return obj instanceof ChatReSendEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatReSendEvent)) {
            return false;
        }
        ChatReSendEvent chatReSendEvent = (ChatReSendEvent) obj;
        if (!chatReSendEvent.canEqual(this)) {
            return false;
        }
        OtcChatContent otcChatContent2 = getOtcChatContent();
        OtcChatContent otcChatContent3 = chatReSendEvent.getOtcChatContent();
        return otcChatContent2 != null ? otcChatContent2.equals(otcChatContent3) : otcChatContent3 == null;
    }

    public OtcChatContent getOtcChatContent() {
        return this.otcChatContent;
    }

    public int hashCode() {
        OtcChatContent otcChatContent2 = getOtcChatContent();
        return 59 + (otcChatContent2 == null ? 43 : otcChatContent2.hashCode());
    }

    public void setOtcChatContent(OtcChatContent otcChatContent2) {
        this.otcChatContent = otcChatContent2;
    }

    public String toString() {
        return "ChatReSendEvent(otcChatContent=" + getOtcChatContent() + ")";
    }
}
