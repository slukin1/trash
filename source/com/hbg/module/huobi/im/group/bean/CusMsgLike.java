package com.hbg.module.huobi.im.group.bean;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CusMsgLike {
    private String groupId;
    private Integer msgSeq;

    public CusMsgLike() {
        this((String) null, (Integer) null, 3, (r) null);
    }

    public CusMsgLike(String str, Integer num) {
        this.groupId = str;
        this.msgSeq = num;
    }

    public static /* synthetic */ CusMsgLike copy$default(CusMsgLike cusMsgLike, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cusMsgLike.groupId;
        }
        if ((i11 & 2) != 0) {
            num = cusMsgLike.msgSeq;
        }
        return cusMsgLike.copy(str, num);
    }

    public final String component1() {
        return this.groupId;
    }

    public final Integer component2() {
        return this.msgSeq;
    }

    public final CusMsgLike copy(String str, Integer num) {
        return new CusMsgLike(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CusMsgLike)) {
            return false;
        }
        CusMsgLike cusMsgLike = (CusMsgLike) obj;
        return x.b(this.groupId, cusMsgLike.groupId) && x.b(this.msgSeq, cusMsgLike.msgSeq);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final Integer getMsgSeq() {
        return this.msgSeq;
    }

    public int hashCode() {
        String str = this.groupId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.msgSeq;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setMsgSeq(Integer num) {
        this.msgSeq = num;
    }

    public String toString() {
        return "CusMsgLike(groupId=" + this.groupId + ", msgSeq=" + this.msgSeq + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgLike(String str, Integer num, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num);
    }
}
