package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcChatPromptLinkContent implements Serializable {
    private String content;
    private String contentValue;
    private String placeholderContent;
    private int placeholderType;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcChatPromptLinkContent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcChatPromptLinkContent)) {
            return false;
        }
        OtcChatPromptLinkContent otcChatPromptLinkContent = (OtcChatPromptLinkContent) obj;
        if (!otcChatPromptLinkContent.canEqual(this) || getType() != otcChatPromptLinkContent.getType()) {
            return false;
        }
        String content2 = getContent();
        String content3 = otcChatPromptLinkContent.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        String contentValue2 = getContentValue();
        String contentValue3 = otcChatPromptLinkContent.getContentValue();
        if (contentValue2 != null ? !contentValue2.equals(contentValue3) : contentValue3 != null) {
            return false;
        }
        if (getPlaceholderType() != otcChatPromptLinkContent.getPlaceholderType()) {
            return false;
        }
        String placeholderContent2 = getPlaceholderContent();
        String placeholderContent3 = otcChatPromptLinkContent.getPlaceholderContent();
        return placeholderContent2 != null ? placeholderContent2.equals(placeholderContent3) : placeholderContent3 == null;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentValue() {
        return this.contentValue;
    }

    public String getPlaceholderContent() {
        return this.placeholderContent;
    }

    public int getPlaceholderType() {
        return this.placeholderType;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String content2 = getContent();
        int i11 = 43;
        int type2 = ((getType() + 59) * 59) + (content2 == null ? 43 : content2.hashCode());
        String contentValue2 = getContentValue();
        int hashCode = (((type2 * 59) + (contentValue2 == null ? 43 : contentValue2.hashCode())) * 59) + getPlaceholderType();
        String placeholderContent2 = getPlaceholderContent();
        int i12 = hashCode * 59;
        if (placeholderContent2 != null) {
            i11 = placeholderContent2.hashCode();
        }
        return i12 + i11;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentValue(String str) {
        this.contentValue = str;
    }

    public void setPlaceholderContent(String str) {
        this.placeholderContent = str;
    }

    public void setPlaceholderType(int i11) {
        this.placeholderType = i11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "OtcChatPromptLinkContent(type=" + getType() + ", content=" + getContent() + ", contentValue=" + getContentValue() + ", placeholderType=" + getPlaceholderType() + ", placeholderContent=" + getPlaceholderContent() + ")";
    }
}
