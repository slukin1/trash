package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class LinearSwapCrossAccountInfo implements Serializable {
    @SerializedName("adjust_factor")
    private String adjustFactor;
    @SerializedName("withdraw_available")
    private String availableWithdraw;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_detail")
    private List<LinearSwapAccountInfo> contractDetail;
    @SerializedName("futures_contract_detail")
    private List<LinearSwapAccountInfo> futuresContractDetail;
    @SerializedName("lever_rate")
    private String leverRate;
    @SerializedName("liquidation_price")
    private String liquidationPrice;
    @SerializedName("margin_account")
    private String marginAccount;
    @SerializedName("margin_asset")
    private String marginAsset;
    @SerializedName("margin_available")
    private String marginAvailable;
    @SerializedName("margin_balance")
    private String marginBalance;
    @SerializedName("margin_frozen")
    private String marginFrozen;
    @SerializedName("margin_mode")
    private String marginMode;
    @SerializedName("margin_position")
    private String marginPosition;
    @SerializedName("margin_static")
    private String marginStatic;
    @SerializedName("money_in")
    private String moneyIn;
    @SerializedName("money_out")
    private String moneyOut;
    @SerializedName("position_mode")
    private String positionMode;
    @SerializedName("profit_real")
    private String profitReal;
    @SerializedName("profit_unreal")
    private String profitUnreal;
    @SerializedName("risk_rate")
    private String riskRate;
    private String symbol;
    @SerializedName("trail_fund")
    private String trailFund;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapCrossAccountInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapCrossAccountInfo)) {
            return false;
        }
        LinearSwapCrossAccountInfo linearSwapCrossAccountInfo = (LinearSwapCrossAccountInfo) obj;
        if (!linearSwapCrossAccountInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapCrossAccountInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapCrossAccountInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String marginBalance2 = getMarginBalance();
        String marginBalance3 = linearSwapCrossAccountInfo.getMarginBalance();
        if (marginBalance2 != null ? !marginBalance2.equals(marginBalance3) : marginBalance3 != null) {
            return false;
        }
        String trailFund2 = getTrailFund();
        String trailFund3 = linearSwapCrossAccountInfo.getTrailFund();
        if (trailFund2 != null ? !trailFund2.equals(trailFund3) : trailFund3 != null) {
            return false;
        }
        String marginPosition2 = getMarginPosition();
        String marginPosition3 = linearSwapCrossAccountInfo.getMarginPosition();
        if (marginPosition2 != null ? !marginPosition2.equals(marginPosition3) : marginPosition3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = linearSwapCrossAccountInfo.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String marginAvailable2 = getMarginAvailable();
        String marginAvailable3 = linearSwapCrossAccountInfo.getMarginAvailable();
        if (marginAvailable2 != null ? !marginAvailable2.equals(marginAvailable3) : marginAvailable3 != null) {
            return false;
        }
        String profitReal2 = getProfitReal();
        String profitReal3 = linearSwapCrossAccountInfo.getProfitReal();
        if (profitReal2 != null ? !profitReal2.equals(profitReal3) : profitReal3 != null) {
            return false;
        }
        String profitUnreal2 = getProfitUnreal();
        String profitUnreal3 = linearSwapCrossAccountInfo.getProfitUnreal();
        if (profitUnreal2 != null ? !profitUnreal2.equals(profitUnreal3) : profitUnreal3 != null) {
            return false;
        }
        String riskRate2 = getRiskRate();
        String riskRate3 = linearSwapCrossAccountInfo.getRiskRate();
        if (riskRate2 != null ? !riskRate2.equals(riskRate3) : riskRate3 != null) {
            return false;
        }
        String liquidationPrice2 = getLiquidationPrice();
        String liquidationPrice3 = linearSwapCrossAccountInfo.getLiquidationPrice();
        if (liquidationPrice2 != null ? !liquidationPrice2.equals(liquidationPrice3) : liquidationPrice3 != null) {
            return false;
        }
        String availableWithdraw2 = getAvailableWithdraw();
        String availableWithdraw3 = linearSwapCrossAccountInfo.getAvailableWithdraw();
        if (availableWithdraw2 != null ? !availableWithdraw2.equals(availableWithdraw3) : availableWithdraw3 != null) {
            return false;
        }
        String leverRate2 = getLeverRate();
        String leverRate3 = linearSwapCrossAccountInfo.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        String adjustFactor2 = getAdjustFactor();
        String adjustFactor3 = linearSwapCrossAccountInfo.getAdjustFactor();
        if (adjustFactor2 != null ? !adjustFactor2.equals(adjustFactor3) : adjustFactor3 != null) {
            return false;
        }
        String marginAsset2 = getMarginAsset();
        String marginAsset3 = linearSwapCrossAccountInfo.getMarginAsset();
        if (marginAsset2 != null ? !marginAsset2.equals(marginAsset3) : marginAsset3 != null) {
            return false;
        }
        String marginMode2 = getMarginMode();
        String marginMode3 = linearSwapCrossAccountInfo.getMarginMode();
        if (marginMode2 != null ? !marginMode2.equals(marginMode3) : marginMode3 != null) {
            return false;
        }
        String marginAccount2 = getMarginAccount();
        String marginAccount3 = linearSwapCrossAccountInfo.getMarginAccount();
        if (marginAccount2 != null ? !marginAccount2.equals(marginAccount3) : marginAccount3 != null) {
            return false;
        }
        String marginStatic2 = getMarginStatic();
        String marginStatic3 = linearSwapCrossAccountInfo.getMarginStatic();
        if (marginStatic2 != null ? !marginStatic2.equals(marginStatic3) : marginStatic3 != null) {
            return false;
        }
        String moneyIn2 = getMoneyIn();
        String moneyIn3 = linearSwapCrossAccountInfo.getMoneyIn();
        if (moneyIn2 != null ? !moneyIn2.equals(moneyIn3) : moneyIn3 != null) {
            return false;
        }
        String moneyOut2 = getMoneyOut();
        String moneyOut3 = linearSwapCrossAccountInfo.getMoneyOut();
        if (moneyOut2 != null ? !moneyOut2.equals(moneyOut3) : moneyOut3 != null) {
            return false;
        }
        List<LinearSwapAccountInfo> contractDetail2 = getContractDetail();
        List<LinearSwapAccountInfo> contractDetail3 = linearSwapCrossAccountInfo.getContractDetail();
        if (contractDetail2 != null ? !contractDetail2.equals(contractDetail3) : contractDetail3 != null) {
            return false;
        }
        List<LinearSwapAccountInfo> futuresContractDetail2 = getFuturesContractDetail();
        List<LinearSwapAccountInfo> futuresContractDetail3 = linearSwapCrossAccountInfo.getFuturesContractDetail();
        if (futuresContractDetail2 != null ? !futuresContractDetail2.equals(futuresContractDetail3) : futuresContractDetail3 != null) {
            return false;
        }
        String positionMode2 = getPositionMode();
        String positionMode3 = linearSwapCrossAccountInfo.getPositionMode();
        return positionMode2 != null ? positionMode2.equals(positionMode3) : positionMode3 == null;
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

    public List<LinearSwapAccountInfo> getContractDetail() {
        return this.contractDetail;
    }

    public List<LinearSwapAccountInfo> getFuturesContractDetail() {
        return this.futuresContractDetail;
    }

    public String getLeverRate() {
        return this.leverRate;
    }

    public String getLiquidationPrice() {
        return this.liquidationPrice;
    }

    public String getMarginAccount() {
        return this.marginAccount;
    }

    public String getMarginAsset() {
        return this.marginAsset;
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

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getMarginPosition() {
        return this.marginPosition;
    }

    public String getMarginStatic() {
        return this.marginStatic;
    }

    public String getMoneyIn() {
        return this.moneyIn;
    }

    public String getMoneyOut() {
        return this.moneyOut;
    }

    public String getPositionMode() {
        return this.positionMode;
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

    public String getTrailFund() {
        return this.trailFund;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String marginBalance2 = getMarginBalance();
        int hashCode3 = (hashCode2 * 59) + (marginBalance2 == null ? 43 : marginBalance2.hashCode());
        String trailFund2 = getTrailFund();
        int hashCode4 = (hashCode3 * 59) + (trailFund2 == null ? 43 : trailFund2.hashCode());
        String marginPosition2 = getMarginPosition();
        int hashCode5 = (hashCode4 * 59) + (marginPosition2 == null ? 43 : marginPosition2.hashCode());
        String marginFrozen2 = getMarginFrozen();
        int hashCode6 = (hashCode5 * 59) + (marginFrozen2 == null ? 43 : marginFrozen2.hashCode());
        String marginAvailable2 = getMarginAvailable();
        int hashCode7 = (hashCode6 * 59) + (marginAvailable2 == null ? 43 : marginAvailable2.hashCode());
        String profitReal2 = getProfitReal();
        int hashCode8 = (hashCode7 * 59) + (profitReal2 == null ? 43 : profitReal2.hashCode());
        String profitUnreal2 = getProfitUnreal();
        int hashCode9 = (hashCode8 * 59) + (profitUnreal2 == null ? 43 : profitUnreal2.hashCode());
        String riskRate2 = getRiskRate();
        int hashCode10 = (hashCode9 * 59) + (riskRate2 == null ? 43 : riskRate2.hashCode());
        String liquidationPrice2 = getLiquidationPrice();
        int hashCode11 = (hashCode10 * 59) + (liquidationPrice2 == null ? 43 : liquidationPrice2.hashCode());
        String availableWithdraw2 = getAvailableWithdraw();
        int hashCode12 = (hashCode11 * 59) + (availableWithdraw2 == null ? 43 : availableWithdraw2.hashCode());
        String leverRate2 = getLeverRate();
        int hashCode13 = (hashCode12 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
        String adjustFactor2 = getAdjustFactor();
        int hashCode14 = (hashCode13 * 59) + (adjustFactor2 == null ? 43 : adjustFactor2.hashCode());
        String marginAsset2 = getMarginAsset();
        int hashCode15 = (hashCode14 * 59) + (marginAsset2 == null ? 43 : marginAsset2.hashCode());
        String marginMode2 = getMarginMode();
        int hashCode16 = (hashCode15 * 59) + (marginMode2 == null ? 43 : marginMode2.hashCode());
        String marginAccount2 = getMarginAccount();
        int hashCode17 = (hashCode16 * 59) + (marginAccount2 == null ? 43 : marginAccount2.hashCode());
        String marginStatic2 = getMarginStatic();
        int hashCode18 = (hashCode17 * 59) + (marginStatic2 == null ? 43 : marginStatic2.hashCode());
        String moneyIn2 = getMoneyIn();
        int hashCode19 = (hashCode18 * 59) + (moneyIn2 == null ? 43 : moneyIn2.hashCode());
        String moneyOut2 = getMoneyOut();
        int hashCode20 = (hashCode19 * 59) + (moneyOut2 == null ? 43 : moneyOut2.hashCode());
        List<LinearSwapAccountInfo> contractDetail2 = getContractDetail();
        int hashCode21 = (hashCode20 * 59) + (contractDetail2 == null ? 43 : contractDetail2.hashCode());
        List<LinearSwapAccountInfo> futuresContractDetail2 = getFuturesContractDetail();
        int hashCode22 = (hashCode21 * 59) + (futuresContractDetail2 == null ? 43 : futuresContractDetail2.hashCode());
        String positionMode2 = getPositionMode();
        int i12 = hashCode22 * 59;
        if (positionMode2 != null) {
            i11 = positionMode2.hashCode();
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

    public void setContractDetail(List<LinearSwapAccountInfo> list) {
        this.contractDetail = list;
    }

    public void setFuturesContractDetail(List<LinearSwapAccountInfo> list) {
        this.futuresContractDetail = list;
    }

    public void setLeverRate(String str) {
        this.leverRate = str;
    }

    public void setLiquidationPrice(String str) {
        this.liquidationPrice = str;
    }

    public void setMarginAccount(String str) {
        this.marginAccount = str;
    }

    public void setMarginAsset(String str) {
        this.marginAsset = str;
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

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setMarginPosition(String str) {
        this.marginPosition = str;
    }

    public void setMarginStatic(String str) {
        this.marginStatic = str;
    }

    public void setMoneyIn(String str) {
        this.moneyIn = str;
    }

    public void setMoneyOut(String str) {
        this.moneyOut = str;
    }

    public void setPositionMode(String str) {
        this.positionMode = str;
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

    public void setTrailFund(String str) {
        this.trailFund = str;
    }

    public String toString() {
        return "LinearSwapCrossAccountInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", marginBalance=" + getMarginBalance() + ", trailFund=" + getTrailFund() + ", marginPosition=" + getMarginPosition() + ", marginFrozen=" + getMarginFrozen() + ", marginAvailable=" + getMarginAvailable() + ", profitReal=" + getProfitReal() + ", profitUnreal=" + getProfitUnreal() + ", riskRate=" + getRiskRate() + ", liquidationPrice=" + getLiquidationPrice() + ", availableWithdraw=" + getAvailableWithdraw() + ", leverRate=" + getLeverRate() + ", adjustFactor=" + getAdjustFactor() + ", marginAsset=" + getMarginAsset() + ", marginMode=" + getMarginMode() + ", marginAccount=" + getMarginAccount() + ", marginStatic=" + getMarginStatic() + ", moneyIn=" + getMoneyIn() + ", moneyOut=" + getMoneyOut() + ", contractDetail=" + getContractDetail() + ", futuresContractDetail=" + getFuturesContractDetail() + ", positionMode=" + getPositionMode() + ")";
    }
}
