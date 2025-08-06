package com.huobi.finance.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.data.symbol.PrecisionUtil;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;

public class MarginSettings implements Serializable {
    private static final long serialVersionUID = -7801343776576863893L;
    @SerializedName("base-currency")
    private String baseCurrency;
    @SerializedName("base-currency-deduct-rate")
    private String baseCurrencyDeductRate;
    @SerializedName("base-currency-interest-rate")
    private String baseCurrencyInterestRate;
    @SerializedName("base-currency-loan-max-amount")
    private String baseCurrencyLoanMaxAmount;
    @SerializedName("base-currency-loan-min-amount")
    private String baseCurrencyLoanMinAmount;
    @SerializedName("day-base-currency-interest-rate")
    private String dayBaseCurrencyInterestRate;
    @SerializedName("day-quote-currency-interest-rate")
    private String dayQuoteCurrencyInterestRate;
    @SerializedName("leverage-ratio")
    private String leverageRatio;
    @SerializedName("quote-currency")
    private String quoteCurrency;
    @SerializedName("quote-currency-deduct-rate")
    private String quoteCurrencyDeductRate;
    @SerializedName("quote-currency-interest-rate")
    private String quoteCurrencyInterestRate;
    @SerializedName("quote-currency-loan-max-amount")
    private String quoteCurrencyLoanMaxAmount;
    @SerializedName("quote-currency-loan-min-amount")
    private String quoteCurrencyLoanMinAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginSettings;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginSettings)) {
            return false;
        }
        MarginSettings marginSettings = (MarginSettings) obj;
        if (!marginSettings.canEqual(this)) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = marginSettings.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = marginSettings.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String baseCurrencyLoanMaxAmount2 = getBaseCurrencyLoanMaxAmount();
        String baseCurrencyLoanMaxAmount3 = marginSettings.getBaseCurrencyLoanMaxAmount();
        if (baseCurrencyLoanMaxAmount2 != null ? !baseCurrencyLoanMaxAmount2.equals(baseCurrencyLoanMaxAmount3) : baseCurrencyLoanMaxAmount3 != null) {
            return false;
        }
        String quoteCurrencyLoanMaxAmount2 = getQuoteCurrencyLoanMaxAmount();
        String quoteCurrencyLoanMaxAmount3 = marginSettings.getQuoteCurrencyLoanMaxAmount();
        if (quoteCurrencyLoanMaxAmount2 != null ? !quoteCurrencyLoanMaxAmount2.equals(quoteCurrencyLoanMaxAmount3) : quoteCurrencyLoanMaxAmount3 != null) {
            return false;
        }
        String baseCurrencyLoanMinAmount2 = getBaseCurrencyLoanMinAmount();
        String baseCurrencyLoanMinAmount3 = marginSettings.getBaseCurrencyLoanMinAmount();
        if (baseCurrencyLoanMinAmount2 != null ? !baseCurrencyLoanMinAmount2.equals(baseCurrencyLoanMinAmount3) : baseCurrencyLoanMinAmount3 != null) {
            return false;
        }
        String quoteCurrencyLoanMinAmount2 = getQuoteCurrencyLoanMinAmount();
        String quoteCurrencyLoanMinAmount3 = marginSettings.getQuoteCurrencyLoanMinAmount();
        if (quoteCurrencyLoanMinAmount2 != null ? !quoteCurrencyLoanMinAmount2.equals(quoteCurrencyLoanMinAmount3) : quoteCurrencyLoanMinAmount3 != null) {
            return false;
        }
        String baseCurrencyInterestRate2 = getBaseCurrencyInterestRate();
        String baseCurrencyInterestRate3 = marginSettings.getBaseCurrencyInterestRate();
        if (baseCurrencyInterestRate2 != null ? !baseCurrencyInterestRate2.equals(baseCurrencyInterestRate3) : baseCurrencyInterestRate3 != null) {
            return false;
        }
        String quoteCurrencyInterestRate2 = getQuoteCurrencyInterestRate();
        String quoteCurrencyInterestRate3 = marginSettings.getQuoteCurrencyInterestRate();
        if (quoteCurrencyInterestRate2 != null ? !quoteCurrencyInterestRate2.equals(quoteCurrencyInterestRate3) : quoteCurrencyInterestRate3 != null) {
            return false;
        }
        String dayQuoteCurrencyInterestRate2 = getDayQuoteCurrencyInterestRate();
        String dayQuoteCurrencyInterestRate3 = marginSettings.getDayQuoteCurrencyInterestRate();
        if (dayQuoteCurrencyInterestRate2 != null ? !dayQuoteCurrencyInterestRate2.equals(dayQuoteCurrencyInterestRate3) : dayQuoteCurrencyInterestRate3 != null) {
            return false;
        }
        String dayBaseCurrencyInterestRate2 = getDayBaseCurrencyInterestRate();
        String dayBaseCurrencyInterestRate3 = marginSettings.getDayBaseCurrencyInterestRate();
        if (dayBaseCurrencyInterestRate2 != null ? !dayBaseCurrencyInterestRate2.equals(dayBaseCurrencyInterestRate3) : dayBaseCurrencyInterestRate3 != null) {
            return false;
        }
        String leverageRatio2 = getLeverageRatio();
        String leverageRatio3 = marginSettings.getLeverageRatio();
        if (leverageRatio2 != null ? !leverageRatio2.equals(leverageRatio3) : leverageRatio3 != null) {
            return false;
        }
        String baseCurrencyDeductRate2 = getBaseCurrencyDeductRate();
        String baseCurrencyDeductRate3 = marginSettings.getBaseCurrencyDeductRate();
        if (baseCurrencyDeductRate2 != null ? !baseCurrencyDeductRate2.equals(baseCurrencyDeductRate3) : baseCurrencyDeductRate3 != null) {
            return false;
        }
        String quoteCurrencyDeductRate2 = getQuoteCurrencyDeductRate();
        String quoteCurrencyDeductRate3 = marginSettings.getQuoteCurrencyDeductRate();
        return quoteCurrencyDeductRate2 != null ? quoteCurrencyDeductRate2.equals(quoteCurrencyDeductRate3) : quoteCurrencyDeductRate3 == null;
    }

    public String formatDeductedRate(boolean z11) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        if (z11) {
            if (TextUtils.isEmpty(this.baseCurrencyDeductRate)) {
                bigDecimal3 = BigDecimal.ONE;
            } else {
                bigDecimal3 = m.a(this.baseCurrencyDeductRate);
            }
            bigDecimal = bigDecimal3.multiply(m.a(this.dayBaseCurrencyInterestRate));
        } else {
            if (TextUtils.isEmpty(this.quoteCurrencyDeductRate)) {
                bigDecimal2 = BigDecimal.ONE;
            } else {
                bigDecimal2 = m.a(this.quoteCurrencyDeductRate);
            }
            bigDecimal = bigDecimal2.multiply(m.a(this.dayQuoteCurrencyInterestRate));
        }
        return m.O(bigDecimal, PrecisionUtil.l(), 4);
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBaseCurrencyDeductRate() {
        return this.baseCurrencyDeductRate;
    }

    public String getBaseCurrencyInterestRate() {
        return this.baseCurrencyInterestRate;
    }

    public String getBaseCurrencyLoanMaxAmount() {
        return this.baseCurrencyLoanMaxAmount;
    }

    public String getBaseCurrencyLoanMinAmount() {
        return this.baseCurrencyLoanMinAmount;
    }

    public String getDayBaseCurrencyInterestRate() {
        return this.dayBaseCurrencyInterestRate;
    }

    public String getDayQuoteCurrencyInterestRate() {
        return this.dayQuoteCurrencyInterestRate;
    }

    public String getLeverageRatio() {
        return this.leverageRatio;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteCurrencyDeductRate() {
        return this.quoteCurrencyDeductRate;
    }

    public String getQuoteCurrencyInterestRate() {
        return this.quoteCurrencyInterestRate;
    }

    public String getQuoteCurrencyLoanMaxAmount() {
        return this.quoteCurrencyLoanMaxAmount;
    }

    public String getQuoteCurrencyLoanMinAmount() {
        return this.quoteCurrencyLoanMinAmount;
    }

    public int hashCode() {
        String baseCurrency2 = getBaseCurrency();
        int i11 = 43;
        int hashCode = baseCurrency2 == null ? 43 : baseCurrency2.hashCode();
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String baseCurrencyLoanMaxAmount2 = getBaseCurrencyLoanMaxAmount();
        int hashCode3 = (hashCode2 * 59) + (baseCurrencyLoanMaxAmount2 == null ? 43 : baseCurrencyLoanMaxAmount2.hashCode());
        String quoteCurrencyLoanMaxAmount2 = getQuoteCurrencyLoanMaxAmount();
        int hashCode4 = (hashCode3 * 59) + (quoteCurrencyLoanMaxAmount2 == null ? 43 : quoteCurrencyLoanMaxAmount2.hashCode());
        String baseCurrencyLoanMinAmount2 = getBaseCurrencyLoanMinAmount();
        int hashCode5 = (hashCode4 * 59) + (baseCurrencyLoanMinAmount2 == null ? 43 : baseCurrencyLoanMinAmount2.hashCode());
        String quoteCurrencyLoanMinAmount2 = getQuoteCurrencyLoanMinAmount();
        int hashCode6 = (hashCode5 * 59) + (quoteCurrencyLoanMinAmount2 == null ? 43 : quoteCurrencyLoanMinAmount2.hashCode());
        String baseCurrencyInterestRate2 = getBaseCurrencyInterestRate();
        int hashCode7 = (hashCode6 * 59) + (baseCurrencyInterestRate2 == null ? 43 : baseCurrencyInterestRate2.hashCode());
        String quoteCurrencyInterestRate2 = getQuoteCurrencyInterestRate();
        int hashCode8 = (hashCode7 * 59) + (quoteCurrencyInterestRate2 == null ? 43 : quoteCurrencyInterestRate2.hashCode());
        String dayQuoteCurrencyInterestRate2 = getDayQuoteCurrencyInterestRate();
        int hashCode9 = (hashCode8 * 59) + (dayQuoteCurrencyInterestRate2 == null ? 43 : dayQuoteCurrencyInterestRate2.hashCode());
        String dayBaseCurrencyInterestRate2 = getDayBaseCurrencyInterestRate();
        int hashCode10 = (hashCode9 * 59) + (dayBaseCurrencyInterestRate2 == null ? 43 : dayBaseCurrencyInterestRate2.hashCode());
        String leverageRatio2 = getLeverageRatio();
        int hashCode11 = (hashCode10 * 59) + (leverageRatio2 == null ? 43 : leverageRatio2.hashCode());
        String baseCurrencyDeductRate2 = getBaseCurrencyDeductRate();
        int hashCode12 = (hashCode11 * 59) + (baseCurrencyDeductRate2 == null ? 43 : baseCurrencyDeductRate2.hashCode());
        String quoteCurrencyDeductRate2 = getQuoteCurrencyDeductRate();
        int i12 = hashCode12 * 59;
        if (quoteCurrencyDeductRate2 != null) {
            i11 = quoteCurrencyDeductRate2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBaseCurrencyDeductRate(String str) {
        this.baseCurrencyDeductRate = str;
    }

    public void setBaseCurrencyInterestRate(String str) {
        this.baseCurrencyInterestRate = str;
    }

    public void setBaseCurrencyLoanMaxAmount(String str) {
        this.baseCurrencyLoanMaxAmount = str;
    }

    public void setBaseCurrencyLoanMinAmount(String str) {
        this.baseCurrencyLoanMinAmount = str;
    }

    public void setDayBaseCurrencyInterestRate(String str) {
        this.dayBaseCurrencyInterestRate = str;
    }

    public void setDayQuoteCurrencyInterestRate(String str) {
        this.dayQuoteCurrencyInterestRate = str;
    }

    public void setLeverageRatio(String str) {
        this.leverageRatio = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteCurrencyDeductRate(String str) {
        this.quoteCurrencyDeductRate = str;
    }

    public void setQuoteCurrencyInterestRate(String str) {
        this.quoteCurrencyInterestRate = str;
    }

    public void setQuoteCurrencyLoanMaxAmount(String str) {
        this.quoteCurrencyLoanMaxAmount = str;
    }

    public void setQuoteCurrencyLoanMinAmount(String str) {
        this.quoteCurrencyLoanMinAmount = str;
    }

    public String toString() {
        return "MarginSettings(baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", baseCurrencyLoanMaxAmount=" + getBaseCurrencyLoanMaxAmount() + ", quoteCurrencyLoanMaxAmount=" + getQuoteCurrencyLoanMaxAmount() + ", baseCurrencyLoanMinAmount=" + getBaseCurrencyLoanMinAmount() + ", quoteCurrencyLoanMinAmount=" + getQuoteCurrencyLoanMinAmount() + ", baseCurrencyInterestRate=" + getBaseCurrencyInterestRate() + ", quoteCurrencyInterestRate=" + getQuoteCurrencyInterestRate() + ", dayQuoteCurrencyInterestRate=" + getDayQuoteCurrencyInterestRate() + ", dayBaseCurrencyInterestRate=" + getDayBaseCurrencyInterestRate() + ", leverageRatio=" + getLeverageRatio() + ", baseCurrencyDeductRate=" + getBaseCurrencyDeductRate() + ", quoteCurrencyDeductRate=" + getQuoteCurrencyDeductRate() + ")";
    }
}
