package com.huobi.supermargin.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TransferOutQuota implements Serializable {
    public static final String STATE_NO_LOAN = "-1";
    private static final long serialVersionUID = 5920769114960171488L;
    @SerializedName("currency")
    private String currency;
    @SerializedName("transfer-out-limit")
    private String transferOutLimit;
    @SerializedName("withdraw-risk")
    private String withdrawRisk;

    public boolean canEqual(Object obj) {
        return obj instanceof TransferOutQuota;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransferOutQuota)) {
            return false;
        }
        TransferOutQuota transferOutQuota = (TransferOutQuota) obj;
        if (!transferOutQuota.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = transferOutQuota.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String transferOutLimit2 = getTransferOutLimit();
        String transferOutLimit3 = transferOutQuota.getTransferOutLimit();
        if (transferOutLimit2 != null ? !transferOutLimit2.equals(transferOutLimit3) : transferOutLimit3 != null) {
            return false;
        }
        String withdrawRisk2 = getWithdrawRisk();
        String withdrawRisk3 = transferOutQuota.getWithdrawRisk();
        return withdrawRisk2 != null ? withdrawRisk2.equals(withdrawRisk3) : withdrawRisk3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getTransferOutLimit() {
        return this.transferOutLimit;
    }

    public String getWithdrawRisk() {
        return this.withdrawRisk;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String transferOutLimit2 = getTransferOutLimit();
        int hashCode2 = ((hashCode + 59) * 59) + (transferOutLimit2 == null ? 43 : transferOutLimit2.hashCode());
        String withdrawRisk2 = getWithdrawRisk();
        int i12 = hashCode2 * 59;
        if (withdrawRisk2 != null) {
            i11 = withdrawRisk2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setTransferOutLimit(String str) {
        this.transferOutLimit = str;
    }

    public void setWithdrawRisk(String str) {
        this.withdrawRisk = str;
    }

    public String toString() {
        return "TransferOutQuota(currency=" + getCurrency() + ", transferOutLimit=" + getTransferOutLimit() + ", withdrawRisk=" + getWithdrawRisk() + ")";
    }
}
