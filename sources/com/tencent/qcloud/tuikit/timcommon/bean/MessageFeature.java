package com.tencent.qcloud.tuikit.timcommon.bean;

import java.io.Serializable;

public class MessageFeature implements Serializable {
    public static final int VERSION = 1;
    private int needTyping = 1;
    private int version = 1;

    public int getNeedTyping() {
        return this.needTyping;
    }

    public int getVersion() {
        return this.version;
    }

    public void setNeedTyping(int i11) {
        this.needTyping = i11;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }
}
