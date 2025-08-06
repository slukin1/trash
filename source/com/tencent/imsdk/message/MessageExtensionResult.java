package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageExtensionResult implements Serializable {
    private MessageExtension extension;
    private int resultCode;
    private String resultInfo;

    public MessageExtension getExtension() {
        return this.extension;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }
}
