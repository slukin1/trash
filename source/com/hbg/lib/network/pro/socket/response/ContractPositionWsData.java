package com.hbg.lib.network.pro.socket.response;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.hbg.lib.network.pro.socket.bean.ContractPositionTpslWs;
import java.io.Serializable;

public class ContractPositionWsData implements Serializable {
    @SerializedName("adl_risk_percent")
    public int adlRiskPercent;
    public String available;
    @SerializedName("contract_code")
    public String contractCode;
    public String contractShortType;
    @SerializedName("contract_type")
    public String contractType;
    @SerializedName("cost_hold")
    public String costHold;
    @SerializedName("cost_open")
    public String costOpen;
    public String costOpenDisplay;
    public String direction;
    public String frozen;
    @SerializedName("last_price")
    public String lastPrice;
    public String lastPriceDisplay;
    @SerializedName("lever_rate")
    public String leverRate;
    @SerializedName("liquidation_price")
    public String liquidationPrice;
    @SerializedName("market_closing_slippage")
    public String marketClosingSlippage;
    @SerializedName("new_risk_rate")
    public String newRiskRate;
    @SerializedName("open_adl")
    public int openAdl;
    public String orderId;
    public String orderPrice;
    public String orderPriceType;
    @SerializedName("position_margin")
    public String positionMargin;
    @SerializedName("position_mode")
    public String positionMode;
    public String profit;
    @SerializedName("profit_rate")
    public String profitRate;
    @SerializedName("profit_unreal")
    public String profitUnreal;
    @SerializedName("risk_rate")
    public String riskRate;
    @SerializedName("sl_order_id")
    public String slOrderId;
    @SerializedName("sl_trigger_price")
    public String slTriggerPrice;
    @SerializedName("sl_trigger_type")
    public String slTriggerType;
    @SerializedName("store_time")
    public String storeTime;
    public String symbol;
    @SerializedName("total_profit_rate")
    public String totalProfitRate;
    @SerializedName("total_win_rate")
    public String totalWinRate;
    @SerializedName("tp_order_id")
    public String tpOrderId;
    @SerializedName("tp_trigger_price")
    public String tpTriggerPrice;
    @SerializedName("tp_trigger_type")
    public String tpTriggerType;
    public String tpslOrderType = "";
    public String triggerPrice;
    private String triggerType = "";
    public String volume;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContractPositionWsData contractPositionWsData = (ContractPositionWsData) obj;
        if (!TextUtils.equals(this.contractCode, contractPositionWsData.contractCode) || !TextUtils.equals(this.direction, contractPositionWsData.direction) || !TextUtils.equals(this.contractShortType, contractPositionWsData.contractShortType)) {
            return false;
        }
        return true;
    }

    public int getAdlRiskPercent() {
        return this.adlRiskPercent;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractShortType() {
        return this.contractShortType;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getCostHold() {
        return this.costHold;
    }

    public String getCostOpen() {
        return this.costOpen;
    }

    public String getCostOpenDisplay() {
        return this.costOpenDisplay;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFrozen() {
        return this.frozen;
    }

    public String getLastPrice() {
        return this.lastPrice;
    }

    public String getLastPriceDisplay() {
        return this.lastPriceDisplay;
    }

    public String getLeverRate() {
        return this.leverRate;
    }

    public String getLiquidationPrice() {
        return this.liquidationPrice;
    }

    public String getMarketClosingSlippage() {
        return this.marketClosingSlippage;
    }

    public String getNewRiskRate() {
        return this.newRiskRate;
    }

    public int getOpenAdl() {
        return this.openAdl;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrderPrice() {
        return this.orderPrice;
    }

    public String getOrderPriceType() {
        return this.orderPriceType;
    }

    public String getPositionMargin() {
        return this.positionMargin;
    }

    public String getPositionMode() {
        return this.positionMode;
    }

    public String getProfit() {
        return this.profit;
    }

    public String getProfitRate() {
        return this.profitRate;
    }

    public String getProfitUnreal() {
        return this.profitUnreal;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public String getSlOrderId() {
        return this.slOrderId;
    }

    public String getSlTriggerPrice() {
        return this.slTriggerPrice;
    }

    public String getSlTriggerType() {
        return this.slTriggerType;
    }

    public String getStoreTime() {
        return this.storeTime;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTotalProfitRate() {
        return this.totalProfitRate;
    }

    public String getTotalWinRate() {
        return this.totalWinRate;
    }

    public String getTpOrderId() {
        return this.tpOrderId;
    }

    public String getTpTriggerPrice() {
        return this.tpTriggerPrice;
    }

    public String getTpTriggerType() {
        return this.tpTriggerType;
    }

    public String getTpslOrderType() {
        return this.tpslOrderType;
    }

    public String getTriggerPrice() {
        return this.triggerPrice;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public String getVolume() {
        return this.volume;
    }

    public boolean isAdl() {
        return this.openAdl == 1;
    }

    public boolean isMarkPriceType() {
        return TextUtils.equals(this.triggerType, LinearSwapTriggerOrderInfo.GE_MARK) || TextUtils.equals(this.triggerType, LinearSwapTriggerOrderInfo.LE_MARK);
    }

    public boolean isSingleMode() {
        return "single_side".equals(this.positionMode);
    }

    public void setAdlRiskPercent(int i11) {
        this.adlRiskPercent = i11;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractShortType(String str) {
        this.contractShortType = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCostHold(String str) {
        this.costHold = str;
    }

    public void setCostOpen(String str) {
        this.costOpen = str;
    }

    public void setCostOpenDisplay(String str) {
        this.costOpenDisplay = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFrozen(String str) {
        this.frozen = str;
    }

    public void setLastPrice(String str) {
        this.lastPrice = str;
    }

    public void setLastPriceDisplay(String str) {
        this.lastPriceDisplay = str;
    }

    public void setLeverRate(String str) {
        this.leverRate = str;
    }

    public void setLiquidationPrice(String str) {
        this.liquidationPrice = str;
    }

    public void setMarketClosingSlippage(String str) {
        this.marketClosingSlippage = str;
    }

    public void setNewRiskRate(String str) {
        this.newRiskRate = str;
    }

    public void setOpenAdl(int i11) {
        this.openAdl = i11;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderPrice(String str) {
        this.orderPrice = str;
    }

    public void setOrderPriceType(String str) {
        this.orderPriceType = str;
    }

    public void setPositionMargin(String str) {
        this.positionMargin = str;
    }

    public void setPositionMode(String str) {
        this.positionMode = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setProfitRate(String str) {
        this.profitRate = str;
    }

    public void setProfitUnreal(String str) {
        this.profitUnreal = str;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setSlOrderId(String str) {
        this.slOrderId = str;
    }

    public void setSlTriggerPrice(String str) {
        this.slTriggerPrice = str;
    }

    public void setSlTriggerType(String str) {
        this.slTriggerType = str;
    }

    public void setStoreTime(String str) {
        this.storeTime = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTotalProfitRate(String str) {
        this.totalProfitRate = str;
    }

    public void setTotalWinRate(String str) {
        this.totalWinRate = str;
    }

    public void setTpOrderId(String str) {
        this.tpOrderId = str;
    }

    public void setTpTriggerPrice(String str) {
        this.tpTriggerPrice = str;
    }

    public void setTpTriggerType(String str) {
        this.tpTriggerType = str;
    }

    public void setTpslOrderType(String str) {
        this.tpslOrderType = str;
    }

    public void setTpslParams(ContractPositionTpslWs contractPositionTpslWs) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        this.tpTriggerPrice = contractPositionTpslWs == null ? null : contractPositionTpslWs.tpTriggerPrice;
        if (contractPositionTpslWs == null) {
            str = null;
        } else {
            str = contractPositionTpslWs.slTriggerPrice;
        }
        this.slTriggerPrice = str;
        if (contractPositionTpslWs == null) {
            str2 = null;
        } else {
            str2 = contractPositionTpslWs.tpTriggerType;
        }
        this.tpTriggerType = str2;
        if (contractPositionTpslWs == null) {
            str3 = null;
        } else {
            str3 = contractPositionTpslWs.slTriggerType;
        }
        this.slTriggerType = str3;
        if (contractPositionTpslWs == null) {
            str4 = null;
        } else {
            str4 = contractPositionTpslWs.tpOrderId;
        }
        this.tpOrderId = str4;
        if (contractPositionTpslWs != null) {
            str5 = contractPositionTpslWs.slOrderId;
        }
        this.slOrderId = str5;
    }

    public void setTriggerPrice(String str) {
        this.triggerPrice = str;
    }

    public void setTriggerType(String str) {
        this.triggerType = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public boolean isMarkPriceType(String str) {
        return TextUtils.equals(str, LinearSwapTriggerOrderInfo.GE_MARK) || TextUtils.equals(str, LinearSwapTriggerOrderInfo.LE_MARK);
    }
}
