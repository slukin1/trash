package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WithdrawAuditCheck implements Serializable {
    private static final long serialVersionUID = 2976107707972317711L;
    @SerializedName("new-address")
    private boolean isNewAddress;
    @SerializedName("self-certificate")
    private boolean isSelfCertificate;

    public boolean isNewAddress() {
        return this.isNewAddress;
    }

    public boolean isSelfCertificate() {
        return this.isSelfCertificate;
    }

    public void setNewAddress(boolean z11) {
        this.isNewAddress = z11;
    }

    public void setSelfCertificate(boolean z11) {
        this.isSelfCertificate = z11;
    }
}
