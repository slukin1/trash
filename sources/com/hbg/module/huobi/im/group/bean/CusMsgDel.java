package com.hbg.module.huobi.im.group.bean;

import kotlin.jvm.internal.r;

public final class CusMsgDel {
    private String groupId;
    private Integer msgSeq;

    public CusMsgDel() {
        this((String) null, (Integer) null, 3, (r) null);
    }

    public CusMsgDel(String str, Integer num) {
        this.groupId = str;
        this.msgSeq = num;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final Integer getMsgSeq() {
        return this.msgSeq;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setMsgSeq(Integer num) {
        this.msgSeq = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgDel(String str, Integer num, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num);
    }
}
