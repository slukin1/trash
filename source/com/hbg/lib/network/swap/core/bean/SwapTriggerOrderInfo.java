package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SwapTriggerOrderInfo implements Serializable {
    public static final String DELIVERY = "settlement";
    public static final String EXPLOSE = "risk";
    public static final String ORDER_DIRECTION_BUY = "buy";
    public static final String ORDER_DIRECTION_SELL = "sell";
    public static final String ORDER_OFFSET_CLOSE = "close";
    public static final String ORDER_OFFSET_OPEN = "open";
    private static final long serialVersionUID = -5118663504382458729L;
    @SerializedName("available_position")
    private String abailablePosition;
    @SerializedName("avg_open")
    private String avgOpen;
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
    @SerializedName("last_price")
    private String lastPrice;
    @SerializedName("lever_rate")
    private int leverRate;
    private String offset;
    @SerializedName("order_id")
    private String orderId;
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
    @SerializedName("relation_order_id")
    private long relationOrderId;
    private int status;
    private String symbol;
    @SerializedName("tpsl_order_type")
    private String tpslOrderType;
    @SerializedName("trigger_price")
    private String triggerPrice;
    @SerializedName("trigger_type")
    private String triggerType;
    @SerializedName("triggered_at")
    private long triggeredAt;
    @SerializedName("triggered_price")
    private String triggeredPrice;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapTriggerOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapTriggerOrderInfo)) {
            return false;
        }
        SwapTriggerOrderInfo swapTriggerOrderInfo = (SwapTriggerOrderInfo) obj;
        if (!swapTriggerOrderInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = swapTriggerOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = swapTriggerOrderInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = swapTriggerOrderInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String triggerType2 = getTriggerType();
        String triggerType3 = swapTriggerOrderInfo.getTriggerType();
        if (triggerType2 != null ? !triggerType2.equals(triggerType3) : triggerType3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = swapTriggerOrderInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        if (getOrderType() != swapTriggerOrderInfo.getOrderType()) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = swapTriggerOrderInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = swapTriggerOrderInfo.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        if (getLeverRate() != swapTriggerOrderInfo.getLeverRate()) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = swapTriggerOrderInfo.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        if (getRelationOrderId() != swapTriggerOrderInfo.getRelationOrderId() || getStatus() != swapTriggerOrderInfo.getStatus()) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = swapTriggerOrderInfo.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        String triggerPrice2 = getTriggerPrice();
        String triggerPrice3 = swapTriggerOrderInfo.getTriggerPrice();
        if (triggerPrice2 != null ? !triggerPrice2.equals(triggerPrice3) : triggerPrice3 != null) {
            return false;
        }
        String triggeredPrice2 = getTriggeredPrice();
        String triggeredPrice3 = swapTriggerOrderInfo.getTriggeredPrice();
        if (triggeredPrice2 != null ? !triggeredPrice2.equals(triggeredPrice3) : triggeredPrice3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = swapTriggerOrderInfo.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = swapTriggerOrderInfo.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        if (getCreatedAt() != swapTriggerOrderInfo.getCreatedAt() || getTriggeredAt() != swapTriggerOrderInfo.getTriggeredAt() || getOrderInsertAt() != swapTriggerOrderInfo.getOrderInsertAt() || getCanceledAt() != swapTriggerOrderInfo.getCanceledAt() || getFailCode() != swapTriggerOrderInfo.getFailCode()) {
            return false;
        }
        String failReason2 = getFailReason();
        String failReason3 = swapTriggerOrderInfo.getFailReason();
        if (failReason2 != null ? !failReason2.equals(failReason3) : failReason3 != null) {
            return false;
        }
        String tpslOrderType2 = getTpslOrderType();
        String tpslOrderType3 = swapTriggerOrderInfo.getTpslOrderType();
        if (tpslOrderType2 != null ? !tpslOrderType2.equals(tpslOrderType3) : tpslOrderType3 != null) {
            return false;
        }
        String abailablePosition2 = getAbailablePosition();
        String abailablePosition3 = swapTriggerOrderInfo.getAbailablePosition();
        if (abailablePosition2 != null ? !abailablePosition2.equals(abailablePosition3) : abailablePosition3 != null) {
            return false;
        }
        String avgOpen2 = getAvgOpen();
        String avgOpen3 = swapTriggerOrderInfo.getAvgOpen();
        if (avgOpen2 != null ? !avgOpen2.equals(avgOpen3) : avgOpen3 != null) {
            return false;
        }
        String lastPrice2 = getLastPrice();
        String lastPrice3 = swapTriggerOrderInfo.getLastPrice();
        return lastPrice2 != null ? lastPrice2.equals(lastPrice3) : lastPrice3 == null;
    }

    public String getAbailablePosition() {
        return this.abailablePosition;
    }

    public String getAvgOpen() {
        return this.avgOpen;
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

    public String getLastPrice() {
        return this.lastPrice;
    }

    public int getLeverRate() {
        return this.leverRate;
    }

    public String getOffset() {
        return this.offset;
    }

    public String getOrderId() {
        return this.orderId;
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

    public long getRelationOrderId() {
        return this.relationOrderId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
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

    public long getTriggeredAt() {
        return this.triggeredAt;
    }

    public String getTriggeredPrice() {
        return this.triggeredPrice;
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
        String contractType2 = getContractType();
        int hashCode3 = (hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String triggerType2 = getTriggerType();
        int hashCode4 = (hashCode3 * 59) + (triggerType2 == null ? 43 : triggerType2.hashCode());
        String volume2 = getVolume();
        int hashCode5 = (((hashCode4 * 59) + (volume2 == null ? 43 : volume2.hashCode())) * 59) + getOrderType();
        String direction2 = getDirection();
        int hashCode6 = (hashCode5 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode7 = (((hashCode6 * 59) + (offset2 == null ? 43 : offset2.hashCode())) * 59) + getLeverRate();
        String orderId2 = getOrderId();
        int hashCode8 = (hashCode7 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
        long relationOrderId2 = getRelationOrderId();
        int status2 = (((hashCode8 * 59) + ((int) (relationOrderId2 ^ (relationOrderId2 >>> 32)))) * 59) + getStatus();
        String orderSource2 = getOrderSource();
        int hashCode9 = (status2 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        String triggerPrice2 = getTriggerPrice();
        int hashCode10 = (hashCode9 * 59) + (triggerPrice2 == null ? 43 : triggerPrice2.hashCode());
        String triggeredPrice2 = getTriggeredPrice();
        int hashCode11 = (hashCode10 * 59) + (triggeredPrice2 == null ? 43 : triggeredPrice2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode12 = (hashCode11 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        String orderPriceType2 = getOrderPriceType();
        int hashCode13 = (hashCode12 * 59) + (orderPriceType2 == null ? 43 : orderPriceType2.hashCode());
        long createdAt2 = getCreatedAt();
        int i12 = (hashCode13 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        long triggeredAt2 = getTriggeredAt();
        int i13 = (i12 * 59) + ((int) (triggeredAt2 ^ (triggeredAt2 >>> 32)));
        long orderInsertAt2 = getOrderInsertAt();
        int i14 = (i13 * 59) + ((int) (orderInsertAt2 ^ (orderInsertAt2 >>> 32)));
        long canceledAt2 = getCanceledAt();
        int failCode2 = (((i14 * 59) + ((int) (canceledAt2 ^ (canceledAt2 >>> 32)))) * 59) + getFailCode();
        String failReason2 = getFailReason();
        int hashCode14 = (failCode2 * 59) + (failReason2 == null ? 43 : failReason2.hashCode());
        String tpslOrderType2 = getTpslOrderType();
        int hashCode15 = (hashCode14 * 59) + (tpslOrderType2 == null ? 43 : tpslOrderType2.hashCode());
        String abailablePosition2 = getAbailablePosition();
        int hashCode16 = (hashCode15 * 59) + (abailablePosition2 == null ? 43 : abailablePosition2.hashCode());
        String avgOpen2 = getAvgOpen();
        int hashCode17 = (hashCode16 * 59) + (avgOpen2 == null ? 43 : avgOpen2.hashCode());
        String lastPrice2 = getLastPrice();
        int i15 = hashCode17 * 59;
        if (lastPrice2 != null) {
            i11 = lastPrice2.hashCode();
        }
        return i15 + i11;
    }

    public boolean isBuy() {
        return "buy".equals(getDirection());
    }

    public boolean isDelivery() {
        return "settlement".equals(getOrderSource());
    }

    public boolean isExplose() {
        return "risk".equals(getOrderSource());
    }

    public boolean isOpen() {
        return "open".equals(getOffset());
    }

    public void setAbailablePosition(String str) {
        this.abailablePosition = str;
    }

    public void setAvgOpen(String str) {
        this.avgOpen = str;
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

    public void setLastPrice(String str) {
        this.lastPrice = str;
    }

    public void setLeverRate(int i11) {
        this.leverRate = i11;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
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

    public void setRelationOrderId(long j11) {
        this.relationOrderId = j11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTpslOrderType(String str) {
        this.tpslOrderType = str;
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

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "SwapTriggerOrderInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", triggerType=" + getTriggerType() + ", volume=" + getVolume() + ", orderType=" + getOrderType() + ", direction=" + getDirection() + ", offset=" + getOffset() + ", leverRate=" + getLeverRate() + ", orderId=" + getOrderId() + ", relationOrderId=" + getRelationOrderId() + ", status=" + getStatus() + ", orderSource=" + getOrderSource() + ", triggerPrice=" + getTriggerPrice() + ", triggeredPrice=" + getTriggeredPrice() + ", orderPrice=" + getOrderPrice() + ", orderPriceType=" + getOrderPriceType() + ", createdAt=" + getCreatedAt() + ", triggeredAt=" + getTriggeredAt() + ", orderInsertAt=" + getOrderInsertAt() + ", canceledAt=" + getCanceledAt() + ", failCode=" + getFailCode() + ", failReason=" + getFailReason() + ", tpslOrderType=" + getTpslOrderType() + ", abailablePosition=" + getAbailablePosition() + ", avgOpen=" + getAvgOpen() + ", lastPrice=" + getLastPrice() + ")";
    }
}
