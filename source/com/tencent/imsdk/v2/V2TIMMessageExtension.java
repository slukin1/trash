package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageExtension;
import java.io.Serializable;

public class V2TIMMessageExtension implements Serializable {
    private MessageExtension extension = new MessageExtension();

    public String getExtensionKey() {
        MessageExtension messageExtension = this.extension;
        if (messageExtension != null) {
            return messageExtension.getExtensionKey();
        }
        return null;
    }

    public String getExtensionValue() {
        MessageExtension messageExtension = this.extension;
        if (messageExtension != null) {
            return messageExtension.getExtensionValue();
        }
        return null;
    }

    public void setExtensionKey(String str) {
        MessageExtension messageExtension = this.extension;
        if (messageExtension != null) {
            messageExtension.setExtensionKey(str);
        }
    }

    public void setExtensionValue(String str) {
        MessageExtension messageExtension = this.extension;
        if (messageExtension != null) {
            messageExtension.setExtensionValue(str);
        }
    }

    public void setMessageExtension(MessageExtension messageExtension) {
        this.extension = messageExtension;
    }

    public String toString() {
        return "V2TIMMessageExtension{extensionKey=" + getExtensionKey() + ",extensionValue=" + getExtensionValue() + '}';
    }
}
