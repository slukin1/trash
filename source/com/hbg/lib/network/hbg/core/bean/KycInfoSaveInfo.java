package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class KycInfoSaveInfo implements Serializable {
    private static final long serialVersionUID = -1565717051797413065L;
    private String authItemSdk;

    /* renamed from: id  reason: collision with root package name */
    private long f70247id;
    private boolean needRedirect;
    private String returnUrl;
    private String ticket;

    public boolean canEqual(Object obj) {
        return obj instanceof KycInfoSaveInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KycInfoSaveInfo)) {
            return false;
        }
        KycInfoSaveInfo kycInfoSaveInfo = (KycInfoSaveInfo) obj;
        if (!kycInfoSaveInfo.canEqual(this) || getId() != kycInfoSaveInfo.getId() || isNeedRedirect() != kycInfoSaveInfo.isNeedRedirect()) {
            return false;
        }
        String returnUrl2 = getReturnUrl();
        String returnUrl3 = kycInfoSaveInfo.getReturnUrl();
        if (returnUrl2 != null ? !returnUrl2.equals(returnUrl3) : returnUrl3 != null) {
            return false;
        }
        String authItemSdk2 = getAuthItemSdk();
        String authItemSdk3 = kycInfoSaveInfo.getAuthItemSdk();
        if (authItemSdk2 != null ? !authItemSdk2.equals(authItemSdk3) : authItemSdk3 != null) {
            return false;
        }
        String ticket2 = getTicket();
        String ticket3 = kycInfoSaveInfo.getTicket();
        return ticket2 != null ? ticket2.equals(ticket3) : ticket3 == null;
    }

    public String getAuthItemSdk() {
        return this.authItemSdk;
    }

    public long getId() {
        return this.f70247id;
    }

    public String getReturnUrl() {
        return this.returnUrl;
    }

    public String getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        long id2 = getId();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (isNeedRedirect() ? 79 : 97);
        String returnUrl2 = getReturnUrl();
        int i12 = 43;
        int hashCode = (i11 * 59) + (returnUrl2 == null ? 43 : returnUrl2.hashCode());
        String authItemSdk2 = getAuthItemSdk();
        int hashCode2 = (hashCode * 59) + (authItemSdk2 == null ? 43 : authItemSdk2.hashCode());
        String ticket2 = getTicket();
        int i13 = hashCode2 * 59;
        if (ticket2 != null) {
            i12 = ticket2.hashCode();
        }
        return i13 + i12;
    }

    public boolean isNeedRedirect() {
        return this.needRedirect;
    }

    public void setAuthItemSdk(String str) {
        this.authItemSdk = str;
    }

    public void setId(long j11) {
        this.f70247id = j11;
    }

    public void setNeedRedirect(boolean z11) {
        this.needRedirect = z11;
    }

    public void setReturnUrl(String str) {
        this.returnUrl = str;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }

    public String toString() {
        return "KycInfoSaveInfo(id=" + getId() + ", needRedirect=" + isNeedRedirect() + ", returnUrl=" + getReturnUrl() + ", authItemSdk=" + getAuthItemSdk() + ", ticket=" + getTicket() + ")";
    }
}
