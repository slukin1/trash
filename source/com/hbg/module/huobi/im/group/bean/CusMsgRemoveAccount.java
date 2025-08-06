package com.hbg.module.huobi.im.group.bean;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CusMsgRemoveAccount {
    private String groupId;
    private String remove_account;

    public CusMsgRemoveAccount() {
        this((String) null, (String) null, 3, (r) null);
    }

    public CusMsgRemoveAccount(String str, String str2) {
        this.groupId = str;
        this.remove_account = str2;
    }

    public static /* synthetic */ CusMsgRemoveAccount copy$default(CusMsgRemoveAccount cusMsgRemoveAccount, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cusMsgRemoveAccount.groupId;
        }
        if ((i11 & 2) != 0) {
            str2 = cusMsgRemoveAccount.remove_account;
        }
        return cusMsgRemoveAccount.copy(str, str2);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.remove_account;
    }

    public final CusMsgRemoveAccount copy(String str, String str2) {
        return new CusMsgRemoveAccount(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CusMsgRemoveAccount)) {
            return false;
        }
        CusMsgRemoveAccount cusMsgRemoveAccount = (CusMsgRemoveAccount) obj;
        return x.b(this.groupId, cusMsgRemoveAccount.groupId) && x.b(this.remove_account, cusMsgRemoveAccount.remove_account);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getRemove_account() {
        return this.remove_account;
    }

    public int hashCode() {
        String str = this.groupId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.remove_account;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setRemove_account(String str) {
        this.remove_account = str;
    }

    public String toString() {
        return "CusMsgRemoveAccount(groupId=" + this.groupId + ", remove_account=" + this.remove_account + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgRemoveAccount(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
