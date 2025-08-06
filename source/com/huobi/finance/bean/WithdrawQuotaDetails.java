package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WithdrawQuotaDetails implements Serializable {
    public String chain;
    @SerializedName("chain-24h-amount")
    public String chain24hAmount = "0";
    @SerializedName("chain-24h-left")
    public String chain24hLeft = "0";
    @SerializedName("chain-24h-type")
    public String chain24hType;
    @SerializedName("single-amount")
    public String singleAmount = "0";
    @SerializedName("total-24h-amount")
    public String total24hAmount = "0";
    @SerializedName("total-24h-currency")
    public String total24hCurrency;
    @SerializedName("total-24h-left")
    public String total24hLeft = "0";

    public boolean canEqual(Object obj) {
        return obj instanceof WithdrawQuotaDetails;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WithdrawQuotaDetails)) {
            return false;
        }
        WithdrawQuotaDetails withdrawQuotaDetails = (WithdrawQuotaDetails) obj;
        if (!withdrawQuotaDetails.canEqual(this)) {
            return false;
        }
        String singleAmount2 = getSingleAmount();
        String singleAmount3 = withdrawQuotaDetails.getSingleAmount();
        if (singleAmount2 != null ? !singleAmount2.equals(singleAmount3) : singleAmount3 != null) {
            return false;
        }
        String total24hAmount2 = getTotal24hAmount();
        String total24hAmount3 = withdrawQuotaDetails.getTotal24hAmount();
        if (total24hAmount2 != null ? !total24hAmount2.equals(total24hAmount3) : total24hAmount3 != null) {
            return false;
        }
        String total24hLeft2 = getTotal24hLeft();
        String total24hLeft3 = withdrawQuotaDetails.getTotal24hLeft();
        if (total24hLeft2 != null ? !total24hLeft2.equals(total24hLeft3) : total24hLeft3 != null) {
            return false;
        }
        String total24hCurrency2 = getTotal24hCurrency();
        String total24hCurrency3 = withdrawQuotaDetails.getTotal24hCurrency();
        if (total24hCurrency2 != null ? !total24hCurrency2.equals(total24hCurrency3) : total24hCurrency3 != null) {
            return false;
        }
        String chain24hAmount2 = getChain24hAmount();
        String chain24hAmount3 = withdrawQuotaDetails.getChain24hAmount();
        if (chain24hAmount2 != null ? !chain24hAmount2.equals(chain24hAmount3) : chain24hAmount3 != null) {
            return false;
        }
        String chain24hLeft2 = getChain24hLeft();
        String chain24hLeft3 = withdrawQuotaDetails.getChain24hLeft();
        if (chain24hLeft2 != null ? !chain24hLeft2.equals(chain24hLeft3) : chain24hLeft3 != null) {
            return false;
        }
        String chain24hType2 = getChain24hType();
        String chain24hType3 = withdrawQuotaDetails.getChain24hType();
        if (chain24hType2 != null ? !chain24hType2.equals(chain24hType3) : chain24hType3 != null) {
            return false;
        }
        String chain2 = getChain();
        String chain3 = withdrawQuotaDetails.getChain();
        return chain2 != null ? chain2.equals(chain3) : chain3 == null;
    }

    public String getChain() {
        return this.chain;
    }

    public String getChain24hAmount() {
        return this.chain24hAmount;
    }

    public String getChain24hLeft() {
        return this.chain24hLeft;
    }

    public String getChain24hType() {
        return this.chain24hType;
    }

    public String getSingleAmount() {
        return this.singleAmount;
    }

    public String getTotal24hAmount() {
        return this.total24hAmount;
    }

    public String getTotal24hCurrency() {
        return this.total24hCurrency;
    }

    public String getTotal24hLeft() {
        return this.total24hLeft;
    }

    public int hashCode() {
        String singleAmount2 = getSingleAmount();
        int i11 = 43;
        int hashCode = singleAmount2 == null ? 43 : singleAmount2.hashCode();
        String total24hAmount2 = getTotal24hAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (total24hAmount2 == null ? 43 : total24hAmount2.hashCode());
        String total24hLeft2 = getTotal24hLeft();
        int hashCode3 = (hashCode2 * 59) + (total24hLeft2 == null ? 43 : total24hLeft2.hashCode());
        String total24hCurrency2 = getTotal24hCurrency();
        int hashCode4 = (hashCode3 * 59) + (total24hCurrency2 == null ? 43 : total24hCurrency2.hashCode());
        String chain24hAmount2 = getChain24hAmount();
        int hashCode5 = (hashCode4 * 59) + (chain24hAmount2 == null ? 43 : chain24hAmount2.hashCode());
        String chain24hLeft2 = getChain24hLeft();
        int hashCode6 = (hashCode5 * 59) + (chain24hLeft2 == null ? 43 : chain24hLeft2.hashCode());
        String chain24hType2 = getChain24hType();
        int hashCode7 = (hashCode6 * 59) + (chain24hType2 == null ? 43 : chain24hType2.hashCode());
        String chain2 = getChain();
        int i12 = hashCode7 * 59;
        if (chain2 != null) {
            i11 = chain2.hashCode();
        }
        return i12 + i11;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public void setChain24hAmount(String str) {
        this.chain24hAmount = str;
    }

    public void setChain24hLeft(String str) {
        this.chain24hLeft = str;
    }

    public void setChain24hType(String str) {
        this.chain24hType = str;
    }

    public void setSingleAmount(String str) {
        this.singleAmount = str;
    }

    public void setTotal24hAmount(String str) {
        this.total24hAmount = str;
    }

    public void setTotal24hCurrency(String str) {
        this.total24hCurrency = str;
    }

    public void setTotal24hLeft(String str) {
        this.total24hLeft = str;
    }

    public String toString() {
        return "WithdrawQuotaDetails(singleAmount=" + getSingleAmount() + ", total24hAmount=" + getTotal24hAmount() + ", total24hLeft=" + getTotal24hLeft() + ", total24hCurrency=" + getTotal24hCurrency() + ", chain24hAmount=" + getChain24hAmount() + ", chain24hLeft=" + getChain24hLeft() + ", chain24hType=" + getChain24hType() + ", chain=" + getChain() + ")";
    }
}
