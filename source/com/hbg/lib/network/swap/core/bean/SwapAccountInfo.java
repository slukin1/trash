package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SwapAccountInfo implements Serializable {
    @SerializedName("adjust_factor")
    private String adjustFactor;
    @SerializedName("withdraw_available")
    private String availableWithdraw;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("lever_rate")
    private String leverRate;
    @SerializedName("liquidation_price")
    private String liquidationPrice;
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
    @SerializedName("profit_real")
    private String profitReal;
    @SerializedName("profit_unreal")
    private String profitUnreal;
    @SerializedName("risk_rate")
    private String riskRate;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapAccountInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapAccountInfo)) {
            return false;
        }
        SwapAccountInfo swapAccountInfo = (SwapAccountInfo) obj;
        if (!swapAccountInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = swapAccountInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = swapAccountInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String marginBalance2 = getMarginBalance();
        String marginBalance3 = swapAccountInfo.getMarginBalance();
        if (marginBalance2 != null ? !marginBalance2.equals(marginBalance3) : marginBalance3 != null) {
            return false;
        }
        String marginPosition2 = getMarginPosition();
        String marginPosition3 = swapAccountInfo.getMarginPosition();
        if (marginPosition2 != null ? !marginPosition2.equals(marginPosition3) : marginPosition3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = swapAccountInfo.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String marginAvailable2 = getMarginAvailable();
        String marginAvailable3 = swapAccountInfo.getMarginAvailable();
        if (marginAvailable2 != null ? !marginAvailable2.equals(marginAvailable3) : marginAvailable3 != null) {
            return false;
        }
        String profitReal2 = getProfitReal();
        String profitReal3 = swapAccountInfo.getProfitReal();
        if (profitReal2 != null ? !profitReal2.equals(profitReal3) : profitReal3 != null) {
            return false;
        }
        String profitUnreal2 = getProfitUnreal();
        String profitUnreal3 = swapAccountInfo.getProfitUnreal();
        if (profitUnreal2 != null ? !profitUnreal2.equals(profitUnreal3) : profitUnreal3 != null) {
            return false;
        }
        String riskRate2 = getRiskRate();
        String riskRate3 = swapAccountInfo.getRiskRate();
        if (riskRate2 != null ? !riskRate2.equals(riskRate3) : riskRate3 != null) {
            return false;
        }
        String liquidationPrice2 = getLiquidationPrice();
        String liquidationPrice3 = swapAccountInfo.getLiquidationPrice();
        if (liquidationPrice2 != null ? !liquidationPrice2.equals(liquidationPrice3) : liquidationPrice3 != null) {
            return false;
        }
        String availableWithdraw2 = getAvailableWithdraw();
        String availableWithdraw3 = swapAccountInfo.getAvailableWithdraw();
        if (availableWithdraw2 != null ? !availableWithdraw2.equals(availableWithdraw3) : availableWithdraw3 != null) {
            return false;
        }
        String leverRate2 = getLeverRate();
        String leverRate3 = swapAccountInfo.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        String adjustFactor2 = getAdjustFactor();
        String adjustFactor3 = swapAccountInfo.getAdjustFactor();
        if (adjustFactor2 != null ? !adjustFactor2.equals(adjustFactor3) : adjustFactor3 != null) {
            return false;
        }
        String marginStatic2 = getMarginStatic();
        String marginStatic3 = swapAccountInfo.getMarginStatic();
        return marginStatic2 != null ? marginStatic2.equals(marginStatic3) : marginStatic3 == null;
    }

    public String getAdjustFactor() {
        return this.adjustFactor;
    }

    public String getAvailableWithdraw() {
        return this.availableWithdraw;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getLeverRate() {
        return this.leverRate;
    }

    public String getLiquidationPrice() {
        return this.liquidationPrice;
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

    public String getProfitReal() {
        return this.profitReal;
    }

    public String getProfitUnreal() {
        return this.profitUnreal;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
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
        String riskRate2 = getRiskRate();
        int hashCode9 = (hashCode8 * 59) + (riskRate2 == null ? 43 : riskRate2.hashCode());
        String liquidationPrice2 = getLiquidationPrice();
        int hashCode10 = (hashCode9 * 59) + (liquidationPrice2 == null ? 43 : liquidationPrice2.hashCode());
        String availableWithdraw2 = getAvailableWithdraw();
        int hashCode11 = (hashCode10 * 59) + (availableWithdraw2 == null ? 43 : availableWithdraw2.hashCode());
        String leverRate2 = getLeverRate();
        int hashCode12 = (hashCode11 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
        String adjustFactor2 = getAdjustFactor();
        int hashCode13 = (hashCode12 * 59) + (adjustFactor2 == null ? 43 : adjustFactor2.hashCode());
        String marginStatic2 = getMarginStatic();
        int i12 = hashCode13 * 59;
        if (marginStatic2 != null) {
            i11 = marginStatic2.hashCode();
        }
        return i12 + i11;
    }

    public void setAdjustFactor(String str) {
        this.adjustFactor = str;
    }

    public void setAvailableWithdraw(String str) {
        this.availableWithdraw = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setLeverRate(String str) {
        this.leverRate = str;
    }

    public void setLiquidationPrice(String str) {
        this.liquidationPrice = str;
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

    public void setProfitReal(String str) {
        this.profitReal = str;
    }

    public void setProfitUnreal(String str) {
        this.profitUnreal = str;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "SwapAccountInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", marginBalance=" + getMarginBalance() + ", marginPosition=" + getMarginPosition() + ", marginFrozen=" + getMarginFrozen() + ", marginAvailable=" + getMarginAvailable() + ", profitReal=" + getProfitReal() + ", profitUnreal=" + getProfitUnreal() + ", riskRate=" + getRiskRate() + ", liquidationPrice=" + getLiquidationPrice() + ", availableWithdraw=" + getAvailableWithdraw() + ", leverRate=" + getLeverRate() + ", adjustFactor=" + getAdjustFactor() + ", marginStatic=" + getMarginStatic() + ")";
    }
}
