package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcCancelChatContent implements Serializable {
    private String content;
    private String title;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCancelChatContent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCancelChatContent)) {
            return false;
        }
        OtcCancelChatContent otcCancelChatContent = (OtcCancelChatContent) obj;
        if (!otcCancelChatContent.canEqual(this) || getType() != otcCancelChatContent.getType()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = otcCancelChatContent.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = otcCancelChatContent.getContent();
        return content2 != null ? content2.equals(content3) : content3 == null;
    }

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String title2 = getTitle();
        int i11 = 43;
        int type2 = ((getType() + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
        String content2 = getContent();
        int i12 = type2 * 59;
        if (content2 != null) {
            i11 = content2.hashCode();
        }
        return i12 + i11;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "OtcCancelChatContent(type=" + getType() + ", title=" + getTitle() + ", content=" + getContent() + ")";
    }
}
