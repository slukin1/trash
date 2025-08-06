package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PledgeBean implements Serializable {
    @SerializedName("currency")
    private String currency;
    @SerializedName("currencyIcon")
    private String currencyIcon;
    @SerializedName("loaningAmount")
    private String loaningAmount;
    @SerializedName("loaningUsdtAmount")
    private String loaningUsdtAmount;
    @SerializedName("pledgingAmount")
    private String pledgingAmount;
    @SerializedName("pledgingUsdtAmount")
    private String pledgingUsdtAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof PledgeBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PledgeBean)) {
            return false;
        }
        PledgeBean pledgeBean = (PledgeBean) obj;
        if (!pledgeBean.canEqual(this)) {
            return false;
        }
        String currencyIcon2 = getCurrencyIcon();
        String currencyIcon3 = pledgeBean.getCurrencyIcon();
        if (currencyIcon2 != null ? !currencyIcon2.equals(currencyIcon3) : currencyIcon3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = pledgeBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String loaningAmount2 = getLoaningAmount();
        String loaningAmount3 = pledgeBean.getLoaningAmount();
        if (loaningAmount2 != null ? !loaningAmount2.equals(loaningAmount3) : loaningAmount3 != null) {
            return false;
        }
        String loaningUsdtAmount2 = getLoaningUsdtAmount();
        String loaningUsdtAmount3 = pledgeBean.getLoaningUsdtAmount();
        if (loaningUsdtAmount2 != null ? !loaningUsdtAmount2.equals(loaningUsdtAmount3) : loaningUsdtAmount3 != null) {
            return false;
        }
        String pledgingAmount2 = getPledgingAmount();
        String pledgingAmount3 = pledgeBean.getPledgingAmount();
        if (pledgingAmount2 != null ? !pledgingAmount2.equals(pledgingAmount3) : pledgingAmount3 != null) {
            return false;
        }
        String pledgingUsdtAmount2 = getPledgingUsdtAmount();
        String pledgingUsdtAmount3 = pledgeBean.getPledgingUsdtAmount();
        return pledgingUsdtAmount2 != null ? pledgingUsdtAmount2.equals(pledgingUsdtAmount3) : pledgingUsdtAmount3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrencyIcon() {
        return this.currencyIcon;
    }

    public String getLoaningAmount() {
        return this.loaningAmount;
    }

    public String getLoaningUsdtAmount() {
        return this.loaningUsdtAmount;
    }

    public String getPledgingAmount() {
        return this.pledgingAmount;
    }

    public String getPledgingUsdtAmount() {
        return this.pledgingUsdtAmount;
    }

    public int hashCode() {
        String currencyIcon2 = getCurrencyIcon();
        int i11 = 43;
        int hashCode = currencyIcon2 == null ? 43 : currencyIcon2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String loaningAmount2 = getLoaningAmount();
        int hashCode3 = (hashCode2 * 59) + (loaningAmount2 == null ? 43 : loaningAmount2.hashCode());
        String loaningUsdtAmount2 = getLoaningUsdtAmount();
        int hashCode4 = (hashCode3 * 59) + (loaningUsdtAmount2 == null ? 43 : loaningUsdtAmount2.hashCode());
        String pledgingAmount2 = getPledgingAmount();
        int hashCode5 = (hashCode4 * 59) + (pledgingAmount2 == null ? 43 : pledgingAmount2.hashCode());
        String pledgingUsdtAmount2 = getPledgingUsdtAmount();
        int i12 = hashCode5 * 59;
        if (pledgingUsdtAmount2 != null) {
            i11 = pledgingUsdtAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyIcon(String str) {
        this.currencyIcon = str;
    }

    public void setLoaningAmount(String str) {
        this.loaningAmount = str;
    }

    public void setLoaningUsdtAmount(String str) {
        this.loaningUsdtAmount = str;
    }

    public void setPledgingAmount(String str) {
        this.pledgingAmount = str;
    }

    public void setPledgingUsdtAmount(String str) {
        this.pledgingUsdtAmount = str;
    }

    public String toString() {
        return "PledgeBean(currencyIcon=" + getCurrencyIcon() + ", currency=" + getCurrency() + ", loaningAmount=" + getLoaningAmount() + ", loaningUsdtAmount=" + getLoaningUsdtAmount() + ", pledgingAmount=" + getPledgingAmount() + ", pledgingUsdtAmount=" + getPledgingUsdtAmount() + ")";
    }
}
