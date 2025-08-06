package com.hbg.module.huobi.im.group.bean;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CusMsgGroupNotification {
    private String groupId;
    private String notification;

    public CusMsgGroupNotification() {
        this((String) null, (String) null, 3, (r) null);
    }

    public CusMsgGroupNotification(String str, String str2) {
        this.groupId = str;
        this.notification = str2;
    }

    public static /* synthetic */ CusMsgGroupNotification copy$default(CusMsgGroupNotification cusMsgGroupNotification, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cusMsgGroupNotification.groupId;
        }
        if ((i11 & 2) != 0) {
            str2 = cusMsgGroupNotification.notification;
        }
        return cusMsgGroupNotification.copy(str, str2);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.notification;
    }

    public final CusMsgGroupNotification copy(String str, String str2) {
        return new CusMsgGroupNotification(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CusMsgGroupNotification)) {
            return false;
        }
        CusMsgGroupNotification cusMsgGroupNotification = (CusMsgGroupNotification) obj;
        return x.b(this.groupId, cusMsgGroupNotification.groupId) && x.b(this.notification, cusMsgGroupNotification.notification);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getNotification() {
        return this.notification;
    }

    public int hashCode() {
        String str = this.groupId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.notification;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setNotification(String str) {
        this.notification = str;
    }

    public String toString() {
        return "CusMsgGroupNotification(groupId=" + this.groupId + ", notification=" + this.notification + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgGroupNotification(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
