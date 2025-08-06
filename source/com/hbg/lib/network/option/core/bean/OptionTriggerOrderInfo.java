package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionTriggerOrderInfo implements Serializable {
    public static final String DELIVERY = "settlement";
    public static final String GE = "ge";
    public static final String LE = "le";
    public static final String ORDER_DIRECTION_BUY = "buy";
    public static final String ORDER_DIRECTION_SELL = "sell";
    public static final String ORDER_OFFSET_CLOSE = "close";
    public static final String ORDER_OFFSET_OPEN = "open";
    public static final String RIGHT_TYPE_C = "C";
    public static final String RIGHT_TYPE_P = "P";
    private static final long serialVersionUID = -8723262099154134122L;
    @SerializedName("contract_code")
    private String contractCode;
    private transient String contractFace;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("created_at")
    private long createdAt;
    private String direction;
    @SerializedName("fail_code")
    private String failCode;
    @SerializedName("fail_reason")
    private String failReason;
    private String offset;
    @SerializedName("option_code")
    private String optionCode;
    @SerializedName("order_id")
    private long orderId;
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
    @SerializedName("trade_partition")
    private String tradePartition;
    @SerializedName("trigger_price")
    private String triggerPrice;
    @SerializedName("trigger_type")
    private String triggerType;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionTriggerOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionTriggerOrderInfo)) {
            return false;
        }
        OptionTriggerOrderInfo optionTriggerOrderInfo = (OptionTriggerOrderInfo) obj;
        if (!optionTriggerOrderInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionTriggerOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = optionTriggerOrderInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = optionTriggerOrderInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = optionTriggerOrderInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String optionCode2 = getOptionCode();
        String optionCode3 = optionTriggerOrderInfo.getOptionCode();
        if (optionCode2 != null ? !optionCode2.equals(optionCode3) : optionCode3 != null) {
            return false;
        }
        String triggerType2 = getTriggerType();
        String triggerType3 = optionTriggerOrderInfo.getTriggerType();
        if (triggerType2 != null ? !triggerType2.equals(triggerType3) : triggerType3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = optionTriggerOrderInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        if (getOrderType() != optionTriggerOrderInfo.getOrderType()) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = optionTriggerOrderInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = optionTriggerOrderInfo.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        if (getOrderId() != optionTriggerOrderInfo.getOrderId() || getRelationOrderId() != optionTriggerOrderInfo.getRelationOrderId()) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = optionTriggerOrderInfo.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        String triggerPrice2 = getTriggerPrice();
        String triggerPrice3 = optionTriggerOrderInfo.getTriggerPrice();
        if (triggerPrice2 != null ? !triggerPrice2.equals(triggerPrice3) : triggerPrice3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = optionTriggerOrderInfo.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        String failCode2 = getFailCode();
        String failCode3 = optionTriggerOrderInfo.getFailCode();
        if (failCode2 != null ? !failCode2.equals(failCode3) : failCode3 != null) {
            return false;
        }
        String failReason2 = getFailReason();
        String failReason3 = optionTriggerOrderInfo.getFailReason();
        if (failReason2 != null ? !failReason2.equals(failReason3) : failReason3 != null) {
            return false;
        }
        if (getCreatedAt() != optionTriggerOrderInfo.getCreatedAt()) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = optionTriggerOrderInfo.getOrderPriceType();
        if (orderPriceType2 != null ? orderPriceType2.equals(orderPriceType3) : orderPriceType3 == null) {
            return getStatus() == optionTriggerOrderInfo.getStatus();
        }
        return false;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractFace() {
        return this.contractFace;
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

    public String getFailCode() {
        return this.failCode;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public String getOffset() {
        return this.offset;
    }

    public String getOptionCode() {
        return this.optionCode;
    }

    public long getOrderId() {
        return this.orderId;
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

    public String getTradePartition() {
        return this.tradePartition;
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

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String tradePartition2 = getTradePartition();
        int hashCode2 = ((hashCode + 59) * 59) + (tradePartition2 == null ? 43 : tradePartition2.hashCode());
        String contractType2 = getContractType();
        int hashCode3 = (hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode4 = (hashCode3 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String optionCode2 = getOptionCode();
        int hashCode5 = (hashCode4 * 59) + (optionCode2 == null ? 43 : optionCode2.hashCode());
        String triggerType2 = getTriggerType();
        int hashCode6 = (hashCode5 * 59) + (triggerType2 == null ? 43 : triggerType2.hashCode());
        String volume2 = getVolume();
        int hashCode7 = (((hashCode6 * 59) + (volume2 == null ? 43 : volume2.hashCode())) * 59) + getOrderType();
        String direction2 = getDirection();
        int hashCode8 = (hashCode7 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode9 = (hashCode8 * 59) + (offset2 == null ? 43 : offset2.hashCode());
        long orderId2 = getOrderId();
        int i12 = (hashCode9 * 59) + ((int) (orderId2 ^ (orderId2 >>> 32)));
        long relationOrderId2 = getRelationOrderId();
        int i13 = (i12 * 59) + ((int) (relationOrderId2 ^ (relationOrderId2 >>> 32)));
        String orderSource2 = getOrderSource();
        int hashCode10 = (i13 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        String triggerPrice2 = getTriggerPrice();
        int hashCode11 = (hashCode10 * 59) + (triggerPrice2 == null ? 43 : triggerPrice2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode12 = (hashCode11 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        String failCode2 = getFailCode();
        int hashCode13 = (hashCode12 * 59) + (failCode2 == null ? 43 : failCode2.hashCode());
        String failReason2 = getFailReason();
        int hashCode14 = (hashCode13 * 59) + (failReason2 == null ? 43 : failReason2.hashCode());
        long createdAt2 = getCreatedAt();
        int i14 = (hashCode14 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String orderPriceType2 = getOrderPriceType();
        int i15 = i14 * 59;
        if (orderPriceType2 != null) {
            i11 = orderPriceType2.hashCode();
        }
        return ((i15 + i11) * 59) + getStatus();
    }

    public boolean isBuy() {
        return "buy".equals(getDirection());
    }

    public boolean isDelivery() {
        return "settlement".equals(getOrderSource());
    }

    public boolean isGe() {
        return "ge".equalsIgnoreCase(this.triggerType);
    }

    public boolean isOpen() {
        return "open".equals(getOffset());
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractFace(String str) {
        this.contractFace = str;
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

    public void setFailCode(String str) {
        this.failCode = str;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOptionCode(String str) {
        this.optionCode = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
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

    public void setTradePartition(String str) {
        this.tradePartition = str;
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

    public String toString() {
        return "OptionTriggerOrderInfo(symbol=" + getSymbol() + ", tradePartition=" + getTradePartition() + ", contractType=" + getContractType() + ", contractCode=" + getContractCode() + ", optionCode=" + getOptionCode() + ", triggerType=" + getTriggerType() + ", volume=" + getVolume() + ", orderType=" + getOrderType() + ", direction=" + getDirection() + ", offset=" + getOffset() + ", orderId=" + getOrderId() + ", relationOrderId=" + getRelationOrderId() + ", orderSource=" + getOrderSource() + ", triggerPrice=" + getTriggerPrice() + ", orderPrice=" + getOrderPrice() + ", failCode=" + getFailCode() + ", failReason=" + getFailReason() + ", createdAt=" + getCreatedAt() + ", orderPriceType=" + getOrderPriceType() + ", status=" + getStatus() + ", contractFace=" + getContractFace() + ")";
    }
}
