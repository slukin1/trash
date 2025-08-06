package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractTpSlOrder implements Serializable {
    private static final long serialVersionUID = 3923434958430342471L;
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
    @SerializedName("lever_rate")
    private String leverRate;
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
        return obj instanceof ContractTpSlOrder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractTpSlOrder)) {
            return false;
        }
        ContractTpSlOrder contractTpSlOrder = (ContractTpSlOrder) obj;
        if (!contractTpSlOrder.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractTpSlOrder.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractTpSlOrder.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractTpSlOrder.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        if (getVolume() != contractTpSlOrder.getVolume() || getOrderType() != contractTpSlOrder.getOrderType()) {
            return false;
        }
        String leverRate2 = getLeverRate();
        String leverRate3 = contractTpSlOrder.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        String tpSlOrderType2 = getTpSlOrderType();
        String tpSlOrderType3 = contractTpSlOrder.getTpSlOrderType();
        if (tpSlOrderType2 != null ? !tpSlOrderType2.equals(tpSlOrderType3) : tpSlOrderType3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = contractTpSlOrder.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = contractTpSlOrder.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = contractTpSlOrder.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        String triggerType2 = getTriggerType();
        String triggerType3 = contractTpSlOrder.getTriggerType();
        if (triggerType2 != null ? !triggerType2.equals(triggerType3) : triggerType3 != null) {
            return false;
        }
        String triggerPrice2 = getTriggerPrice();
        String triggerPrice3 = contractTpSlOrder.getTriggerPrice();
        if (triggerPrice2 != null ? !triggerPrice2.equals(triggerPrice3) : triggerPrice3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = contractTpSlOrder.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        if (getCreatedAt() != contractTpSlOrder.getCreatedAt() || getOrderPriceType() != contractTpSlOrder.getOrderPriceType() || getStatus() != contractTpSlOrder.getStatus()) {
            return false;
        }
        String sourceOrderId2 = getSourceOrderId();
        String sourceOrderId3 = contractTpSlOrder.getSourceOrderId();
        if (sourceOrderId2 != null ? !sourceOrderId2.equals(sourceOrderId3) : sourceOrderId3 != null) {
            return false;
        }
        String relationTpSlOrderId2 = getRelationTpSlOrderId();
        String relationTpSlOrderId3 = contractTpSlOrder.getRelationTpSlOrderId();
        if (relationTpSlOrderId2 != null ? !relationTpSlOrderId2.equals(relationTpSlOrderId3) : relationTpSlOrderId3 != null) {
            return false;
        }
        if (getCanceledAt() != contractTpSlOrder.getCanceledAt() || getFailCode() != contractTpSlOrder.getFailCode()) {
            return false;
        }
        String failReason2 = getFailReason();
        String failReason3 = contractTpSlOrder.getFailReason();
        if (failReason2 != null ? !failReason2.equals(failReason3) : failReason3 != null) {
            return false;
        }
        String triggeredPrice2 = getTriggeredPrice();
        String triggeredPrice3 = contractTpSlOrder.getTriggeredPrice();
        if (triggeredPrice2 != null ? !triggeredPrice2.equals(triggeredPrice3) : triggeredPrice3 != null) {
            return false;
        }
        String relationOrderId2 = getRelationOrderId();
        String relationOrderId3 = contractTpSlOrder.getRelationOrderId();
        if (relationOrderId2 != null ? relationOrderId2.equals(relationOrderId3) : relationOrderId3 == null) {
            return getUpdateTime() == contractTpSlOrder.getUpdateTime() && getTriggeredAt() == contractTpSlOrder.getTriggeredAt();
        }
        return false;
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

    public String getLeverRate() {
        return this.leverRate;
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
        String contractType2 = getContractType();
        int hashCode3 = (((((hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode())) * 59) + getVolume()) * 59) + getOrderType();
        String leverRate2 = getLeverRate();
        int hashCode4 = (hashCode3 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
        String tpSlOrderType2 = getTpSlOrderType();
        int hashCode5 = (hashCode4 * 59) + (tpSlOrderType2 == null ? 43 : tpSlOrderType2.hashCode());
        String direction2 = getDirection();
        int hashCode6 = (hashCode5 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String orderId2 = getOrderId();
        int hashCode7 = (hashCode6 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
        String orderSource2 = getOrderSource();
        int hashCode8 = (hashCode7 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        String triggerType2 = getTriggerType();
        int hashCode9 = (hashCode8 * 59) + (triggerType2 == null ? 43 : triggerType2.hashCode());
        String triggerPrice2 = getTriggerPrice();
        int hashCode10 = (hashCode9 * 59) + (triggerPrice2 == null ? 43 : triggerPrice2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode11 = (hashCode10 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        long createdAt2 = getCreatedAt();
        int orderPriceType2 = (((((hashCode11 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)))) * 59) + getOrderPriceType()) * 59) + getStatus();
        String sourceOrderId2 = getSourceOrderId();
        int hashCode12 = (orderPriceType2 * 59) + (sourceOrderId2 == null ? 43 : sourceOrderId2.hashCode());
        String relationTpSlOrderId2 = getRelationTpSlOrderId();
        int hashCode13 = (hashCode12 * 59) + (relationTpSlOrderId2 == null ? 43 : relationTpSlOrderId2.hashCode());
        long canceledAt2 = getCanceledAt();
        int failCode2 = (((hashCode13 * 59) + ((int) (canceledAt2 ^ (canceledAt2 >>> 32)))) * 59) + getFailCode();
        String failReason2 = getFailReason();
        int hashCode14 = (failCode2 * 59) + (failReason2 == null ? 43 : failReason2.hashCode());
        String triggeredPrice2 = getTriggeredPrice();
        int hashCode15 = (hashCode14 * 59) + (triggeredPrice2 == null ? 43 : triggeredPrice2.hashCode());
        String relationOrderId2 = getRelationOrderId();
        int i12 = hashCode15 * 59;
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

    public void setLeverRate(String str) {
        this.leverRate = str;
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
        return "ContractTpSlOrder(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", volume=" + getVolume() + ", orderType=" + getOrderType() + ", leverRate=" + getLeverRate() + ", tpSlOrderType=" + getTpSlOrderType() + ", direction=" + getDirection() + ", orderId=" + getOrderId() + ", orderSource=" + getOrderSource() + ", triggerType=" + getTriggerType() + ", triggerPrice=" + getTriggerPrice() + ", orderPrice=" + getOrderPrice() + ", createdAt=" + getCreatedAt() + ", orderPriceType=" + getOrderPriceType() + ", status=" + getStatus() + ", sourceOrderId=" + getSourceOrderId() + ", relationTpSlOrderId=" + getRelationTpSlOrderId() + ", canceledAt=" + getCanceledAt() + ", failCode=" + getFailCode() + ", failReason=" + getFailReason() + ", triggeredPrice=" + getTriggeredPrice() + ", relationOrderId=" + getRelationOrderId() + ", updateTime=" + getUpdateTime() + ", triggeredAt=" + getTriggeredAt() + ")";
    }
}
