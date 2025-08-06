package com.huobi.account.entity;

import java.io.Serializable;

public class InviteConfigBean implements Serializable {
    private static final long serialVersionUID = 4375979099749432786L;
    private boolean commission;
    private boolean newCommission;

    public boolean canEqual(Object obj) {
        return obj instanceof InviteConfigBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InviteConfigBean)) {
            return false;
        }
        InviteConfigBean inviteConfigBean = (InviteConfigBean) obj;
        return inviteConfigBean.canEqual(this) && isCommission() == inviteConfigBean.isCommission() && isNewCommission() == inviteConfigBean.isNewCommission();
    }

    public int hashCode() {
        int i11 = 79;
        int i12 = ((isCommission() ? 79 : 97) + 59) * 59;
        if (!isNewCommission()) {
            i11 = 97;
        }
        return i12 + i11;
    }

    public boolean isCommission() {
        return this.commission;
    }

    public boolean isNewCommission() {
        return this.newCommission;
    }

    public void setCommission(boolean z11) {
        this.commission = z11;
    }

    public void setNewCommission(boolean z11) {
        this.newCommission = z11;
    }

    public String toString() {
        return "InviteConfigBean(commission=" + isCommission() + ", newCommission=" + isNewCommission() + ")";
    }
}
