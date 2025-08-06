package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapTpSlOrder implements Serializable {
    private static final long serialVersionUID = 3923434958430342471L;
    @SerializedName("canceled_at")
    private long canceledAt;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("created_at")
    private long createdAt;
    private String direction;
    @SerializedName("fail_code")
    private int failCode;
    @SerializedName("fail_reason")
    private String failReason;
    @SerializedName("lever_rate")
    private String leverRate;
    @SerializedName("margin_account")
    private String marginAccount;
    @SerializedName("margin_mode")
    private String marginMode;
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("order_price")
    private String orderPrice;
    @SerializedName("order_price_type")
    private int orderPriceType;
    @SerializedName("order_source")
    private String orderSource;
    @SerializedName("order_type")
    private int orderType;
    @SerializedName("relation_order_id")
    private String relationOrderId;
    @SerializedName("relation_tpsl_order_id")
    private String relationTpSlOrderId;
    @SerializedName("source_order_id")
    private String sourceOrderId;
    private int status;
    private String symbol;
    @SerializedName("tpsl_order_type")
    private String tpSlOrderType;
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
    private int volume;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapTpSlOrder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapTpSlOrder)) {
            return false;
        }
        LinearSwapTpSlOrder linearSwapTpSlOrder = (LinearSwapTpSlOrder) obj;
        if (!linearSwapTpSlOrder.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapTpSlOrder.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapTpSlOrder.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String marginMode2 = getMarginMode();
        String marginMode3 = linearSwapTpSlOrder.getMarginMode();
        if (marginMode2 != null ? !marginMode2.equals(marginMode3) : marginMode3 != null) {
            return false;
        }
        String marginAccount2 = getMarginAccount();
        String marginAccount3 = linearSwapTpSlOrder.getMarginAccount();
        if (marginAccount2 != null ? !marginAccount2.equals(marginAccount3) : marginAccount3 != null) {
            return false;
        }
        if (getVolume() != linearSwapTpSlOrder.getVolume() || getOrderType() != linearSwapTpSlOrder.getOrderType()) {
            return false;
        }
        String leverRate2 = getLeverRate();
        String leverRate3 = linearSwapTpSlOrder.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        String tpSlOrderType2 = getTpSlOrderType();
        String tpSlOrderType3 = linearSwapTpSlOrder.getTpSlOrderType();
        if (tpSlOrderType2 != null ? !tpSlOrderType2.equals(tpSlOrderType3) : tpSlOrderType3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = linearSwapTpSlOrder.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = linearSwapTpSlOrder.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = linearSwapTpSlOrder.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        String triggerType2 = getTriggerType();
        String triggerType3 = linearSwapTpSlOrder.getTriggerType();
        if (triggerType2 != null ? !triggerType2.equals(triggerType3) : triggerType3 != null) {
            return false;
        }
        String triggerPrice2 = getTriggerPrice();
        String triggerPrice3 = linearSwapTpSlOrder.getTriggerPrice();
        if (triggerPrice2 != null ? !triggerPrice2.equals(triggerPrice3) : triggerPrice3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = linearSwapTpSlOrder.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        if (getCreatedAt() != linearSwapTpSlOrder.getCreatedAt() || getOrderPriceType() != linearSwapTpSlOrder.getOrderPriceType() || getStatus() != linearSwapTpSlOrder.getStatus()) {
            return false;
        }
        String sourceOrderId2 = getSourceOrderId();
        String sourceOrderId3 = linearSwapTpSlOrder.getSourceOrderId();
        if (sourceOrderId2 != null ? !sourceOrderId2.equals(sourceOrderId3) : sourceOrderId3 != null) {
            return false;
        }
        String relationTpSlOrderId2 = getRelationTpSlOrderId();
        String relationTpSlOrderId3 = linearSwapTpSlOrder.getRelationTpSlOrderId();
        if (relationTpSlOrderId2 != null ? !relationTpSlOrderId2.equals(relationTpSlOrderId3) : relationTpSlOrderId3 != null) {
            return false;
        }
        if (getCanceledAt() != linearSwapTpSlOrder.getCanceledAt() || getFailCode() != linearSwapTpSlOrder.getFailCode()) {
            return false;
        }
        String failReason2 = getFailReason();
        String failReason3 = linearSwapTpSlOrder.getFailReason();
        if (failReason2 != null ? !failReason2.equals(failReason3) : failReason3 != null) {
            return false;
        }
        String triggeredPrice2 = getTriggeredPrice();
        String triggeredPrice3 = linearSwapTpSlOrder.getTriggeredPrice();
        if (triggeredPrice2 != null ? !triggeredPrice2.equals(triggeredPrice3) : triggeredPrice3 != null) {
            return false;
        }
        String relationOrderId2 = getRelationOrderId();
        String relationOrderId3 = linearSwapTpSlOrder.getRelationOrderId();
        if (relationOrderId2 != null ? relationOrderId2.equals(relationOrderId3) : relationOrderId3 == null) {
            return getUpdateTime() == linearSwapTpSlOrder.getUpdateTime() && getTriggeredAt() == linearSwapTpSlOrder.getTriggeredAt();
        }
        return false;
    }

    public long getCanceledAt() {
        return this.canceledAt;
    }

    public String getContractCode() {
        return this.contractCode;
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

    public String getLeverRate() {
        return this.leverRate;
    }

    public String getMarginAccount() {
        return this.marginAccount;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrderPrice() {
        return this.orderPrice;
    }

    public int getOrderPriceType() {
        return this.orderPriceType;
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public String getRelationOrderId() {
        return this.relationOrderId;
    }

    public String getRelationTpSlOrderId() {
        return this.relationTpSlOrderId;
    }

    public String getSourceOrderId() {
        return this.sourceOrderId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTpSlOrderType() {
        return this.tpSlOrderType;
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

    public int getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String marginMode2 = getMarginMode();
        int hashCode3 = (hashCode2 * 59) + (marginMode2 == null ? 43 : marginMode2.hashCode());
        String marginAccount2 = getMarginAccount();
        int hashCode4 = (((((hashCode3 * 59) + (marginAccount2 == null ? 43 : marginAccount2.hashCode())) * 59) + getVolume()) * 59) + getOrderType();
        String leverRate2 = getLeverRate();
        int hashCode5 = (hashCode4 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
        String tpSlOrderType2 = getTpSlOrderType();
        int hashCode6 = (hashCode5 * 59) + (tpSlOrderType2 == null ? 43 : tpSlOrderType2.hashCode());
        String direction2 = getDirection();
        int hashCode7 = (hashCode6 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String orderId2 = getOrderId();
        int hashCode8 = (hashCode7 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
        String orderSource2 = getOrderSource();
        int hashCode9 = (hashCode8 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        String triggerType2 = getTriggerType();
        int hashCode10 = (hashCode9 * 59) + (triggerType2 == null ? 43 : triggerType2.hashCode());
        String triggerPrice2 = getTriggerPrice();
        int hashCode11 = (hashCode10 * 59) + (triggerPrice2 == null ? 43 : triggerPrice2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode12 = (hashCode11 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        long createdAt2 = getCreatedAt();
        int orderPriceType2 = (((((hashCode12 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)))) * 59) + getOrderPriceType()) * 59) + getStatus();
        String sourceOrderId2 = getSourceOrderId();
        int hashCode13 = (orderPriceType2 * 59) + (sourceOrderId2 == null ? 43 : sourceOrderId2.hashCode());
        String relationTpSlOrderId2 = getRelationTpSlOrderId();
        int hashCode14 = (hashCode13 * 59) + (relationTpSlOrderId2 == null ? 43 : relationTpSlOrderId2.hashCode());
        long canceledAt2 = getCanceledAt();
        int failCode2 = (((hashCode14 * 59) + ((int) (canceledAt2 ^ (canceledAt2 >>> 32)))) * 59) + getFailCode();
        String failReason2 = getFailReason();
        int hashCode15 = (failCode2 * 59) + (failReason2 == null ? 43 : failReason2.hashCode());
        String triggeredPrice2 = getTriggeredPrice();
        int hashCode16 = (hashCode15 * 59) + (triggeredPrice2 == null ? 43 : triggeredPrice2.hashCode());
        String relationOrderId2 = getRelationOrderId();
        int i12 = hashCode16 * 59;
        if (relationOrderId2 != null) {
            i11 = relationOrderId2.hashCode();
        }
        long updateTime2 = getUpdateTime();
        long triggeredAt2 = getTriggeredAt();
        return ((((i12 + i11) * 59) + ((int) (updateTime2 ^ (updateTime2 >>> 32)))) * 59) + ((int) ((triggeredAt2 >>> 32) ^ triggeredAt2));
    }

    public void setCanceledAt(long j11) {
        this.canceledAt = j11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
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

    public void setLeverRate(String str) {
        this.leverRate = str;
    }

    public void setMarginAccount(String str) {
        this.marginAccount = str;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderPrice(String str) {
        this.orderPrice = str;
    }

    public void setOrderPriceType(int i11) {
        this.orderPriceType = i11;
    }

    public void setOrderSource(String str) {
        this.orderSource = str;
    }

    public void setOrderType(int i11) {
        this.orderType = i11;
    }

    public void setRelationOrderId(String str) {
        this.relationOrderId = str;
    }

    public void setRelationTpSlOrderId(String str) {
        this.relationTpSlOrderId = str;
    }

    public void setSourceOrderId(String str) {
        this.sourceOrderId = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTpSlOrderType(String str) {
        this.tpSlOrderType = str;
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

    public void setVolume(int i11) {
        this.volume = i11;
    }

    public String toString() {
        return "LinearSwapTpSlOrder(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", marginMode=" + getMarginMode() + ", marginAccount=" + getMarginAccount() + ", volume=" + getVolume() + ", orderType=" + getOrderType() + ", leverRate=" + getLeverRate() + ", tpSlOrderType=" + getTpSlOrderType() + ", direction=" + getDirection() + ", orderId=" + getOrderId() + ", orderSource=" + getOrderSource() + ", triggerType=" + getTriggerType() + ", triggerPrice=" + getTriggerPrice() + ", orderPrice=" + getOrderPrice() + ", createdAt=" + getCreatedAt() + ", orderPriceType=" + getOrderPriceType() + ", status=" + getStatus() + ", sourceOrderId=" + getSourceOrderId() + ", relationTpSlOrderId=" + getRelationTpSlOrderId() + ", canceledAt=" + getCanceledAt() + ", failCode=" + getFailCode() + ", failReason=" + getFailReason() + ", triggeredPrice=" + getTriggeredPrice() + ", relationOrderId=" + getRelationOrderId() + ", updateTime=" + getUpdateTime() + ", triggeredAt=" + getTriggeredAt() + ")";
    }
}
