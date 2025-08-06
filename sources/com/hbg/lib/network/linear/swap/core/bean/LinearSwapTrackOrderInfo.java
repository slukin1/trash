package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapTrackOrderInfo implements Serializable {
    public static final int IS_ACTIVE = 1;
    public static final int IS_NOT_ACTIVE = 0;
    private static final long serialVersionUID = -5118663504382458729L;
    @SerializedName("active_price")
    private String activePrice;
    @SerializedName("active_type")
    private String activeType;
    @SerializedName("business_type")
    private String businessType;
    @SerializedName("callback_rate")
    private String callbackRate;
    @SerializedName("canceled_at")
    private long canceledAt;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("created_at")
    private long createdAt;
    private String direction;
    @SerializedName("fail_code")
    private int failCode;
    @SerializedName("fail_reason")
    private String failReason;
    @SerializedName("formula_price")
    private String formulaPrice;
    @SerializedName("is_active")
    private int isActive;
    @SerializedName("lever_rate")
    private int leverRate;
    @SerializedName("liquidation_type")
    private String liquidationType;
    @SerializedName("margin_mode")
    private String marginMode;
    @SerializedName("market_limit_price")
    private String marketLimitPrice;
    private String offset;
    @SerializedName("order_id")
    private long orderId;
    @SerializedName("order_id_str")
    private String orderIdStr;
    @SerializedName("order_insert_at")
    private long orderInsertAt;
    @SerializedName("order_price")
    private String orderPrice;
    @SerializedName("order_price_type")
    private String orderPriceType;
    @SerializedName("order_source")
    private String orderSource;
    @SerializedName("order_type")
    private int orderType;
    private String pair;
    @SerializedName("real_volume")
    private String realVolume;
    @SerializedName("relation_order_id")
    private long relationOrderId;
    private int status;
    private String symbol;
    @SerializedName("trade_partition")
    private String tradePartition;
    @SerializedName("trigger_price")
    private String triggerPrice;
    @SerializedName("trigger_type")
    private String triggerType;
    @SerializedName("triggered_at")
    private long triggeredAt;
    @SerializedName("triggered_price")
    private String triggeredPrice;
    @SerializedName("update_time")
    private long updateTime;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapTrackOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapTrackOrderInfo)) {
            return false;
        }
        LinearSwapTrackOrderInfo linearSwapTrackOrderInfo = (LinearSwapTrackOrderInfo) obj;
        if (!linearSwapTrackOrderInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapTrackOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapTrackOrderInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String triggerType2 = getTriggerType();
        String triggerType3 = linearSwapTrackOrderInfo.getTriggerType();
        if (triggerType2 != null ? !triggerType2.equals(triggerType3) : triggerType3 != null) {
            return false;
        }
        String activeType2 = getActiveType();
        String activeType3 = linearSwapTrackOrderInfo.getActiveType();
        if (activeType2 != null ? !activeType2.equals(activeType3) : activeType3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = linearSwapTrackOrderInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        if (getOrderType() != linearSwapTrackOrderInfo.getOrderType()) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = linearSwapTrackOrderInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = linearSwapTrackOrderInfo.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        if (getLeverRate() != linearSwapTrackOrderInfo.getLeverRate() || getOrderId() != linearSwapTrackOrderInfo.getOrderId()) {
            return false;
        }
        String orderIdStr2 = getOrderIdStr();
        String orderIdStr3 = linearSwapTrackOrderInfo.getOrderIdStr();
        if (orderIdStr2 != null ? !orderIdStr2.equals(orderIdStr3) : orderIdStr3 != null) {
            return false;
        }
        String marketLimitPrice2 = getMarketLimitPrice();
        String marketLimitPrice3 = linearSwapTrackOrderInfo.getMarketLimitPrice();
        if (marketLimitPrice2 != null ? !marketLimitPrice2.equals(marketLimitPrice3) : marketLimitPrice3 != null) {
            return false;
        }
        if (getRelationOrderId() != linearSwapTrackOrderInfo.getRelationOrderId() || getStatus() != linearSwapTrackOrderInfo.getStatus()) {
            return false;
        }
        String realVolume2 = getRealVolume();
        String realVolume3 = linearSwapTrackOrderInfo.getRealVolume();
        if (realVolume2 != null ? !realVolume2.equals(realVolume3) : realVolume3 != null) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = linearSwapTrackOrderInfo.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        String triggerPrice2 = getTriggerPrice();
        String triggerPrice3 = linearSwapTrackOrderInfo.getTriggerPrice();
        if (triggerPrice2 != null ? !triggerPrice2.equals(triggerPrice3) : triggerPrice3 != null) {
            return false;
        }
        String triggeredPrice2 = getTriggeredPrice();
        String triggeredPrice3 = linearSwapTrackOrderInfo.getTriggeredPrice();
        if (triggeredPrice2 != null ? !triggeredPrice2.equals(triggeredPrice3) : triggeredPrice3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = linearSwapTrackOrderInfo.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = linearSwapTrackOrderInfo.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        if (getCreatedAt() != linearSwapTrackOrderInfo.getCreatedAt() || getTriggeredAt() != linearSwapTrackOrderInfo.getTriggeredAt() || getOrderInsertAt() != linearSwapTrackOrderInfo.getOrderInsertAt() || getCanceledAt() != linearSwapTrackOrderInfo.getCanceledAt() || getFailCode() != linearSwapTrackOrderInfo.getFailCode()) {
            return false;
        }
        String failReason2 = getFailReason();
        String failReason3 = linearSwapTrackOrderInfo.getFailReason();
        if (failReason2 != null ? !failReason2.equals(failReason3) : failReason3 != null) {
            return false;
        }
        String liquidationType2 = getLiquidationType();
        String liquidationType3 = linearSwapTrackOrderInfo.getLiquidationType();
        if (liquidationType2 != null ? !liquidationType2.equals(liquidationType3) : liquidationType3 != null) {
            return false;
        }
        if (getUpdateTime() != linearSwapTrackOrderInfo.getUpdateTime()) {
            return false;
        }
        String callbackRate2 = getCallbackRate();
        String callbackRate3 = linearSwapTrackOrderInfo.getCallbackRate();
        if (callbackRate2 != null ? !callbackRate2.equals(callbackRate3) : callbackRate3 != null) {
            return false;
        }
        String activePrice2 = getActivePrice();
        String activePrice3 = linearSwapTrackOrderInfo.getActivePrice();
        if (activePrice2 != null ? !activePrice2.equals(activePrice3) : activePrice3 != null) {
            return false;
        }
        String formulaPrice2 = getFormulaPrice();
        String formulaPrice3 = linearSwapTrackOrderInfo.getFormulaPrice();
        if (formulaPrice2 != null ? !formulaPrice2.equals(formulaPrice3) : formulaPrice3 != null) {
            return false;
        }
        if (getIsActive() != linearSwapTrackOrderInfo.getIsActive()) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = linearSwapTrackOrderInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String businessType2 = getBusinessType();
        String businessType3 = linearSwapTrackOrderInfo.getBusinessType();
        if (businessType2 != null ? !businessType2.equals(businessType3) : businessType3 != null) {
            return false;
        }
        String pair2 = getPair();
        String pair3 = linearSwapTrackOrderInfo.getPair();
        if (pair2 != null ? !pair2.equals(pair3) : pair3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = linearSwapTrackOrderInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String marginMode2 = getMarginMode();
        String marginMode3 = linearSwapTrackOrderInfo.getMarginMode();
        return marginMode2 != null ? marginMode2.equals(marginMode3) : marginMode3 == null;
    }

    public String getActivePrice() {
        return this.activePrice;
    }

    public String getActiveType() {
        return this.activeType;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public String getCallbackRate() {
        return this.callbackRate;
    }

    public long getCanceledAt() {
        return this.canceledAt;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getDirection() {
        return this.direction;
    }

    public int getFailCode() {
        return this.failCode;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public String getFormulaPrice() {
        return this.formulaPrice;
    }

    public int getIsActive() {
        return this.isActive;
    }

    public int getLeverRate() {
        return this.leverRate;
    }

    public String getLiquidationType() {
        return this.liquidationType;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getMarketLimitPrice() {
        return this.marketLimitPrice;
    }

    public String getOffset() {
        return this.offset;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public String getOrderIdStr() {
        return this.orderIdStr;
    }

    public long getOrderInsertAt() {
        return this.orderInsertAt;
    }

    public String getOrderPrice() {
        return this.orderPrice;
    }

    public String getOrderPriceType() {
        return this.orderPriceType;
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public String getPair() {
        return this.pair;
    }

    public String getRealVolume() {
        return this.realVolume;
    }

    public long getRelationOrderId() {
        return this.relationOrderId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public String getTriggerPrice() {
        return this.triggerPrice;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public long getTriggeredAt() {
        return this.triggeredAt;
    }

    public String getTriggeredPrice() {
        return this.triggeredPrice;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String triggerType2 = getTriggerType();
        int hashCode3 = (hashCode2 * 59) + (triggerType2 == null ? 43 : triggerType2.hashCode());
        String activeType2 = getActiveType();
        int hashCode4 = (hashCode3 * 59) + (activeType2 == null ? 43 : activeType2.hashCode());
        String volume2 = getVolume();
        int hashCode5 = (((hashCode4 * 59) + (volume2 == null ? 43 : volume2.hashCode())) * 59) + getOrderType();
        String direction2 = getDirection();
        int hashCode6 = (hashCode5 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode7 = (((hashCode6 * 59) + (offset2 == null ? 43 : offset2.hashCode())) * 59) + getLeverRate();
        long orderId2 = getOrderId();
        int i12 = (hashCode7 * 59) + ((int) (orderId2 ^ (orderId2 >>> 32)));
        String orderIdStr2 = getOrderIdStr();
        int hashCode8 = (i12 * 59) + (orderIdStr2 == null ? 43 : orderIdStr2.hashCode());
        String marketLimitPrice2 = getMarketLimitPrice();
        int hashCode9 = (hashCode8 * 59) + (marketLimitPrice2 == null ? 43 : marketLimitPrice2.hashCode());
        long relationOrderId2 = getRelationOrderId();
        int status2 = (((hashCode9 * 59) + ((int) (relationOrderId2 ^ (relationOrderId2 >>> 32)))) * 59) + getStatus();
        String realVolume2 = getRealVolume();
        int hashCode10 = (status2 * 59) + (realVolume2 == null ? 43 : realVolume2.hashCode());
        String orderSource2 = getOrderSource();
        int hashCode11 = (hashCode10 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        String triggerPrice2 = getTriggerPrice();
        int hashCode12 = (hashCode11 * 59) + (triggerPrice2 == null ? 43 : triggerPrice2.hashCode());
        String triggeredPrice2 = getTriggeredPrice();
        int hashCode13 = (hashCode12 * 59) + (triggeredPrice2 == null ? 43 : triggeredPrice2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode14 = (hashCode13 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        String orderPriceType2 = getOrderPriceType();
        int hashCode15 = (hashCode14 * 59) + (orderPriceType2 == null ? 43 : orderPriceType2.hashCode());
        long createdAt2 = getCreatedAt();
        int i13 = (hashCode15 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        long triggeredAt2 = getTriggeredAt();
        int i14 = (i13 * 59) + ((int) (triggeredAt2 ^ (triggeredAt2 >>> 32)));
        long orderInsertAt2 = getOrderInsertAt();
        int i15 = (i14 * 59) + ((int) (orderInsertAt2 ^ (orderInsertAt2 >>> 32)));
        long canceledAt2 = getCanceledAt();
        int failCode2 = (((i15 * 59) + ((int) (canceledAt2 ^ (canceledAt2 >>> 32)))) * 59) + getFailCode();
        String failReason2 = getFailReason();
        int hashCode16 = (failCode2 * 59) + (failReason2 == null ? 43 : failReason2.hashCode());
        String liquidationType2 = getLiquidationType();
        int hashCode17 = (hashCode16 * 59) + (liquidationType2 == null ? 43 : liquidationType2.hashCode());
        long updateTime2 = getUpdateTime();
        int i16 = (hashCode17 * 59) + ((int) (updateTime2 ^ (updateTime2 >>> 32)));
        String callbackRate2 = getCallbackRate();
        int hashCode18 = (i16 * 59) + (callbackRate2 == null ? 43 : callbackRate2.hashCode());
        String activePrice2 = getActivePrice();
        int hashCode19 = (hashCode18 * 59) + (activePrice2 == null ? 43 : activePrice2.hashCode());
        String formulaPrice2 = getFormulaPrice();
        int hashCode20 = (((hashCode19 * 59) + (formulaPrice2 == null ? 43 : formulaPrice2.hashCode())) * 59) + getIsActive();
        String contractType2 = getContractType();
        int hashCode21 = (hashCode20 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String businessType2 = getBusinessType();
        int hashCode22 = (hashCode21 * 59) + (businessType2 == null ? 43 : businessType2.hashCode());
        String pair2 = getPair();
        int hashCode23 = (hashCode22 * 59) + (pair2 == null ? 43 : pair2.hashCode());
        String tradePartition2 = getTradePartition();
        int hashCode24 = (hashCode23 * 59) + (tradePartition2 == null ? 43 : tradePartition2.hashCode());
        String marginMode2 = getMarginMode();
        int i17 = hashCode24 * 59;
        if (marginMode2 != null) {
            i11 = marginMode2.hashCode();
        }
        return i17 + i11;
    }

    public void setActivePrice(String str) {
        this.activePrice = str;
    }

    public void setActiveType(String str) {
        this.activeType = str;
    }

    public void setBusinessType(String str) {
        this.businessType = str;
    }

    public void setCallbackRate(String str) {
        this.callbackRate = str;
    }

    public void setCanceledAt(long j11) {
        this.canceledAt = j11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFailCode(int i11) {
        this.failCode = i11;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setFormulaPrice(String str) {
        this.formulaPrice = str;
    }

    public void setIsActive(int i11) {
        this.isActive = i11;
    }

    public void setLeverRate(int i11) {
        this.leverRate = i11;
    }

    public void setLiquidationType(String str) {
        this.liquidationType = str;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setMarketLimitPrice(String str) {
        this.marketLimitPrice = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setOrderIdStr(String str) {
        this.orderIdStr = str;
    }

    public void setOrderInsertAt(long j11) {
        this.orderInsertAt = j11;
    }

    public void setOrderPrice(String str) {
        this.orderPrice = str;
    }

    public void setOrderPriceType(String str) {
        this.orderPriceType = str;
    }

    public void setOrderSource(String str) {
        this.orderSource = str;
    }

    public void setOrderType(int i11) {
        this.orderType = i11;
    }

    public void setPair(String str) {
        this.pair = str;
    }

    public void setRealVolume(String str) {
        this.realVolume = str;
    }

    public void setRelationOrderId(long j11) {
        this.relationOrderId = j11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public void setTriggerPrice(String str) {
        this.triggerPrice = str;
    }

    public void setTriggerType(String str) {
        this.triggerType = str;
    }

    public void setTriggeredAt(long j11) {
        this.triggeredAt = j11;
    }

    public void setTriggeredPrice(String str) {
        this.triggeredPrice = str;
    }

    public void setUpdateTime(long j11) {
        this.updateTime = j11;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "LinearSwapTrackOrderInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", triggerType=" + getTriggerType() + ", activeType=" + getActiveType() + ", volume=" + getVolume() + ", orderType=" + getOrderType() + ", direction=" + getDirection() + ", offset=" + getOffset() + ", leverRate=" + getLeverRate() + ", orderId=" + getOrderId() + ", orderIdStr=" + getOrderIdStr() + ", marketLimitPrice=" + getMarketLimitPrice() + ", relationOrderId=" + getRelationOrderId() + ", status=" + getStatus() + ", realVolume=" + getRealVolume() + ", orderSource=" + getOrderSource() + ", triggerPrice=" + getTriggerPrice() + ", triggeredPrice=" + getTriggeredPrice() + ", orderPrice=" + getOrderPrice() + ", orderPriceType=" + getOrderPriceType() + ", createdAt=" + getCreatedAt() + ", triggeredAt=" + getTriggeredAt() + ", orderInsertAt=" + getOrderInsertAt() + ", canceledAt=" + getCanceledAt() + ", failCode=" + getFailCode() + ", failReason=" + getFailReason() + ", liquidationType=" + getLiquidationType() + ", updateTime=" + getUpdateTime() + ", callbackRate=" + getCallbackRate() + ", activePrice=" + getActivePrice() + ", formulaPrice=" + getFormulaPrice() + ", isActive=" + getIsActive() + ", contractType=" + getContractType() + ", businessType=" + getBusinessType() + ", pair=" + getPair() + ", tradePartition=" + getTradePartition() + ", marginMode=" + getMarginMode() + ")";
    }
}
