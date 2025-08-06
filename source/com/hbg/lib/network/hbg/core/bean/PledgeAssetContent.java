package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PledgeAssetContent implements Serializable {
    @SerializedName("loaningUSDT")
    private String loaningUSDT;
    @SerializedName("pledgingUSDT")
    private String pledgingUSDT;

    public boolean canEqual(Object obj) {
        return obj instanceof PledgeAssetContent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PledgeAssetContent)) {
            return false;
        }
        PledgeAssetContent pledgeAssetContent = (PledgeAssetContent) obj;
        if (!pledgeAssetContent.canEqual(this)) {
            return false;
        }
        String loaningUSDT2 = getLoaningUSDT();
        String loaningUSDT3 = pledgeAssetContent.getLoaningUSDT();
        if (loaningUSDT2 != null ? !loaningUSDT2.equals(loaningUSDT3) : loaningUSDT3 != null) {
            return false;
        }
        String pledgingUSDT2 = getPledgingUSDT();
        String pledgingUSDT3 = pledgeAssetContent.getPledgingUSDT();
        return pledgingUSDT2 != null ? pledgingUSDT2.equals(pledgingUSDT3) : pledgingUSDT3 == null;
    }

    public String getLoaningUSDT() {
        return this.loaningUSDT;
    }

    public String getPledgingUSDT() {
        return this.pledgingUSDT;
    }

    public int hashCode() {
        String loaningUSDT2 = getLoaningUSDT();
        int i11 = 43;
        int hashCode = loaningUSDT2 == null ? 43 : loaningUSDT2.hashCode();
        String pledgingUSDT2 = getPledgingUSDT();
        int i12 = (hashCode + 59) * 59;
        if (pledgingUSDT2 != null) {
            i11 = pledgingUSDT2.hashCode();
        }
        return i12 + i11;
    }

    public void setLoaningUSDT(String str) {
        this.loaningUSDT = str;
    }

    public void setPledgingUSDT(String str) {
        this.pledgingUSDT = str;
    }

    public String toString() {
        return "PledgeAssetContent{loaningUSDT='" + this.loaningUSDT + '\'' + ", pledgingUSDT='" + this.pledgingUSDT + '\'' + '}';
    }
}
