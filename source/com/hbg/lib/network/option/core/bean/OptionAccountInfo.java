package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionAccountInfo implements Serializable {
    private double delta;
    @SerializedName("fee_asset")
    private String feeAsset;
    @SerializedName("fee_frozen")
    private String feeFrozen;
    private String gamma;
    @SerializedName("margin_available")
    private String marginAvailable;
    @SerializedName("margin_balance")
    private String marginBalance;
    @SerializedName("margin_frozen")
    private String marginFrozen;
    @SerializedName("margin_position")
    private String marginPosition;
    @SerializedName("margin_static")
    private String marginStatic;
    @SerializedName("option_value")
    private String optionValue;
    @SerializedName("frozen_premium")
    private String premiumFrozen;
    @SerializedName("premium_in")
    private String premiumIn;
    @SerializedName("premium_out")
    private String premiumOut;
    @SerializedName("profit_real")
    private String profitReal;
    @SerializedName("profit_unreal")
    private String profitUnreal;
    private String symbol;
    private double theta;
    @SerializedName("trade_partition")
    private String tradePartition;
    private String vega;
    @SerializedName("withdraw_available")
    private String withdrawAvailable;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionAccountInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionAccountInfo)) {
            return false;
        }
        OptionAccountInfo optionAccountInfo = (OptionAccountInfo) obj;
        if (!optionAccountInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionAccountInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = optionAccountInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String marginBalance2 = getMarginBalance();
        String marginBalance3 = optionAccountInfo.getMarginBalance();
        if (marginBalance2 != null ? !marginBalance2.equals(marginBalance3) : marginBalance3 != null) {
            return false;
        }
        String marginPosition2 = getMarginPosition();
        String marginPosition3 = optionAccountInfo.getMarginPosition();
        if (marginPosition2 != null ? !marginPosition2.equals(marginPosition3) : marginPosition3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = optionAccountInfo.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String marginAvailable2 = getMarginAvailable();
        String marginAvailable3 = optionAccountInfo.getMarginAvailable();
        if (marginAvailable2 != null ? !marginAvailable2.equals(marginAvailable3) : marginAvailable3 != null) {
            return false;
        }
        String profitReal2 = getProfitReal();
        String profitReal3 = optionAccountInfo.getProfitReal();
        if (profitReal2 != null ? !profitReal2.equals(profitReal3) : profitReal3 != null) {
            return false;
        }
        String profitUnreal2 = getProfitUnreal();
        String profitUnreal3 = optionAccountInfo.getProfitUnreal();
        if (profitUnreal2 != null ? !profitUnreal2.equals(profitUnreal3) : profitUnreal3 != null) {
            return false;
        }
        String withdrawAvailable2 = getWithdrawAvailable();
        String withdrawAvailable3 = optionAccountInfo.getWithdrawAvailable();
        if (withdrawAvailable2 != null ? !withdrawAvailable2.equals(withdrawAvailable3) : withdrawAvailable3 != null) {
            return false;
        }
        String marginStatic2 = getMarginStatic();
        String marginStatic3 = optionAccountInfo.getMarginStatic();
        if (marginStatic2 != null ? !marginStatic2.equals(marginStatic3) : marginStatic3 != null) {
            return false;
        }
        String premiumFrozen2 = getPremiumFrozen();
        String premiumFrozen3 = optionAccountInfo.getPremiumFrozen();
        if (premiumFrozen2 != null ? !premiumFrozen2.equals(premiumFrozen3) : premiumFrozen3 != null) {
            return false;
        }
        String feeFrozen2 = getFeeFrozen();
        String feeFrozen3 = optionAccountInfo.getFeeFrozen();
        if (feeFrozen2 != null ? !feeFrozen2.equals(feeFrozen3) : feeFrozen3 != null) {
            return false;
        }
        String feeAsset2 = getFeeAsset();
        String feeAsset3 = optionAccountInfo.getFeeAsset();
        if (feeAsset2 != null ? !feeAsset2.equals(feeAsset3) : feeAsset3 != null) {
            return false;
        }
        String premiumIn2 = getPremiumIn();
        String premiumIn3 = optionAccountInfo.getPremiumIn();
        if (premiumIn2 != null ? !premiumIn2.equals(premiumIn3) : premiumIn3 != null) {
            return false;
        }
        String premiumOut2 = getPremiumOut();
        String premiumOut3 = optionAccountInfo.getPremiumOut();
        if (premiumOut2 != null ? !premiumOut2.equals(premiumOut3) : premiumOut3 != null) {
            return false;
        }
        if (Double.compare(getDelta(), optionAccountInfo.getDelta()) != 0) {
            return false;
        }
        String gamma2 = getGamma();
        String gamma3 = optionAccountInfo.getGamma();
        if (gamma2 != null ? !gamma2.equals(gamma3) : gamma3 != null) {
            return false;
        }
        if (Double.compare(getTheta(), optionAccountInfo.getTheta()) != 0) {
            return false;
        }
        String vega2 = getVega();
        String vega3 = optionAccountInfo.getVega();
        if (vega2 != null ? !vega2.equals(vega3) : vega3 != null) {
            return false;
        }
        String optionValue2 = getOptionValue();
        String optionValue3 = optionAccountInfo.getOptionValue();
        return optionValue2 != null ? optionValue2.equals(optionValue3) : optionValue3 == null;
    }

    public double getDelta() {
        return this.delta;
    }

    public String getFeeAsset() {
        return this.feeAsset;
    }

    public String getFeeFrozen() {
        return this.feeFrozen;
    }

    public String getGamma() {
        return this.gamma;
    }

    public String getMarginAvailable() {
        return this.marginAvailable;
    }

    public String getMarginBalance() {
        return this.marginBalance;
    }

    public String getMarginFrozen() {
        return this.marginFrozen;
    }

    public String getMarginPosition() {
        return this.marginPosition;
    }

    public String getMarginStatic() {
        return this.marginStatic;
    }

    public String getOptionValue() {
        return this.optionValue;
    }

    public String getPremiumFrozen() {
        return this.premiumFrozen;
    }

    public String getPremiumIn() {
        return this.premiumIn;
    }

    public String getPremiumOut() {
        return this.premiumOut;
    }

    public String getProfitReal() {
        return this.profitReal;
    }

    public String getProfitUnreal() {
        return this.profitUnreal;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getTheta() {
        return this.theta;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public String getVega() {
        return this.vega;
    }

    public String getWithdrawAvailable() {
        return this.withdrawAvailable;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String tradePartition2 = getTradePartition();
        int hashCode2 = ((hashCode + 59) * 59) + (tradePartition2 == null ? 43 : tradePartition2.hashCode());
        String marginBalance2 = getMarginBalance();
        int hashCode3 = (hashCode2 * 59) + (marginBalance2 == null ? 43 : marginBalance2.hashCode());
        String marginPosition2 = getMarginPosition();
        int hashCode4 = (hashCode3 * 59) + (marginPosition2 == null ? 43 : marginPosition2.hashCode());
        String marginFrozen2 = getMarginFrozen();
        int hashCode5 = (hashCode4 * 59) + (marginFrozen2 == null ? 43 : marginFrozen2.hashCode());
        String marginAvailable2 = getMarginAvailable();
        int hashCode6 = (hashCode5 * 59) + (marginAvailable2 == null ? 43 : marginAvailable2.hashCode());
        String profitReal2 = getProfitReal();
        int hashCode7 = (hashCode6 * 59) + (profitReal2 == null ? 43 : profitReal2.hashCode());
        String profitUnreal2 = getProfitUnreal();
        int hashCode8 = (hashCode7 * 59) + (profitUnreal2 == null ? 43 : profitUnreal2.hashCode());
        String withdrawAvailable2 = getWithdrawAvailable();
        int hashCode9 = (hashCode8 * 59) + (withdrawAvailable2 == null ? 43 : withdrawAvailable2.hashCode());
        String marginStatic2 = getMarginStatic();
        int hashCode10 = (hashCode9 * 59) + (marginStatic2 == null ? 43 : marginStatic2.hashCode());
        String premiumFrozen2 = getPremiumFrozen();
        int hashCode11 = (hashCode10 * 59) + (premiumFrozen2 == null ? 43 : premiumFrozen2.hashCode());
        String feeFrozen2 = getFeeFrozen();
        int hashCode12 = (hashCode11 * 59) + (feeFrozen2 == null ? 43 : feeFrozen2.hashCode());
        String feeAsset2 = getFeeAsset();
        int hashCode13 = (hashCode12 * 59) + (feeAsset2 == null ? 43 : feeAsset2.hashCode());
        String premiumIn2 = getPremiumIn();
        int hashCode14 = (hashCode13 * 59) + (premiumIn2 == null ? 43 : premiumIn2.hashCode());
        String premiumOut2 = getPremiumOut();
        int hashCode15 = (hashCode14 * 59) + (premiumOut2 == null ? 43 : premiumOut2.hashCode());
        long doubleToLongBits = Double.doubleToLongBits(getDelta());
        int i12 = (hashCode15 * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        String gamma2 = getGamma();
        int hashCode16 = (i12 * 59) + (gamma2 == null ? 43 : gamma2.hashCode());
        long doubleToLongBits2 = Double.doubleToLongBits(getTheta());
        int i13 = (hashCode16 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        String vega2 = getVega();
        int hashCode17 = (i13 * 59) + (vega2 == null ? 43 : vega2.hashCode());
        String optionValue2 = getOptionValue();
        int i14 = hashCode17 * 59;
        if (optionValue2 != null) {
            i11 = optionValue2.hashCode();
        }
        return i14 + i11;
    }

    public void setDelta(double d11) {
        this.delta = d11;
    }

    public void setFeeAsset(String str) {
        this.feeAsset = str;
    }

    public void setFeeFrozen(String str) {
        this.feeFrozen = str;
    }

    public void setGamma(String str) {
        this.gamma = str;
    }

    public void setMarginAvailable(String str) {
        this.marginAvailable = str;
    }

    public void setMarginBalance(String str) {
        this.marginBalance = str;
    }

    public void setMarginFrozen(String str) {
        this.marginFrozen = str;
    }

    public void setMarginPosition(String str) {
        this.marginPosition = str;
    }

    public void setMarginStatic(String str) {
        this.marginStatic = str;
    }

    public void setOptionValue(String str) {
        this.optionValue = str;
    }

    public void setPremiumFrozen(String str) {
        this.premiumFrozen = str;
    }

    public void setPremiumIn(String str) {
        this.premiumIn = str;
    }

    public void setPremiumOut(String str) {
        this.premiumOut = str;
    }

    public void setProfitReal(String str) {
        this.profitReal = str;
    }

    public void setProfitUnreal(String str) {
        this.profitUnreal = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTheta(double d11) {
        this.theta = d11;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public void setVega(String str) {
        this.vega = str;
    }

    public void setWithdrawAvailable(String str) {
        this.withdrawAvailable = str;
    }

    public String toString() {
        return "OptionAccountInfo(symbol=" + getSymbol() + ", tradePartition=" + getTradePartition() + ", marginBalance=" + getMarginBalance() + ", marginPosition=" + getMarginPosition() + ", marginFrozen=" + getMarginFrozen() + ", marginAvailable=" + getMarginAvailable() + ", profitReal=" + getProfitReal() + ", profitUnreal=" + getProfitUnreal() + ", withdrawAvailable=" + getWithdrawAvailable() + ", marginStatic=" + getMarginStatic() + ", premiumFrozen=" + getPremiumFrozen() + ", feeFrozen=" + getFeeFrozen() + ", feeAsset=" + getFeeAsset() + ", premiumIn=" + getPremiumIn() + ", premiumOut=" + getPremiumOut() + ", delta=" + getDelta() + ", gamma=" + getGamma() + ", theta=" + getTheta() + ", vega=" + getVega() + ", optionValue=" + getOptionValue() + ")";
    }
}
