package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageExtension implements Serializable {
    private String extensionKey;
    private String extensionValue;

    public String getExtensionKey() {
        return this.extensionKey;
    }

    public String getExtensionValue() {
        return this.extensionValue;
    }

    public void setExtensionKey(String str) {
        this.extensionKey = str;
    }

    public void setExtensionValue(String str) {
        this.extensionValue = str;
    }
}
