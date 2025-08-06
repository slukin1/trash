package com.tencent.android.tpush.data;

import java.io.Serializable;

public class PushClickEntity implements Serializable {
    private static final long serialVersionUID = -166678396447407161L;
    public long accessId = 0;
    public int action = 0;
    public long broadcastId = 0;
    public long clickTime = 0;
    public String groupId = "";
    public long msgId = 0;
    public String pkgName = "";
    public long timestamp = 0;
    public long type = 1;

    public PushClickEntity() {
    }

    public PushClickEntity(long j11, long j12, long j13, long j14, String str, long j15, long j16, int i11, String str2) {
        this.msgId = j11;
        this.accessId = j12;
        this.broadcastId = j13;
        this.timestamp = j14;
        this.pkgName = str;
        this.type = j15;
        this.clickTime = j16;
        this.action = i11;
        this.groupId = str2;
    }
}
