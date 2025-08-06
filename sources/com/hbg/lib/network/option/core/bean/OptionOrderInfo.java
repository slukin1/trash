package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionOrderInfo implements Serializable {
    public static final String DELIVERY = "settlement";
    public static final String ORDER_DIRECTION_BUY = "buy";
    public static final String ORDER_DIRECTION_SELL = "sell";
    public static final String ORDER_OFFSET_CLOSE = "close";
    public static final String ORDER_OFFSET_OPEN = "open";
    public static final String RIGHT_TYPE_C = "C";
    public static final String RIGHT_TYPE_P = "P";
    private static final long serialVersionUID = -8723262099154134122L;
    @SerializedName("client_order_id")
    private long clientOrderId;
    @SerializedName("contract_code")
    private String contractCode;
    private transient String contractFace;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("delivery_date")
    private String deliveryDate;
    private String direction;
    @SerializedName("exercise_price")
    private String exercisePrice;
    private String fee;
    @SerializedName("fee_asset")
    private String feeAsset;
    @SerializedName("fee_frozen")
    private String feeFrozen;
    @SerializedName("frozen_premium")
    private String frozenPremium;
    @SerializedName("margin_frozen")
    private String marginFrozen;
    private String offset;
    @SerializedName("option_code")
    private String optionCode;
    @SerializedName("option_right_type")
    private String optionRightType;
    @SerializedName("order_id")
    private long orderId;
    @SerializedName("order_id_str")
    private String orderIdStr;
    @SerializedName("order_price_type")
    private String orderPriceType;
    @SerializedName("order_source")
    private String orderSource;
    @SerializedName("order_type")
    private int orderType;
    private String price;
    private String profit;
    @SerializedName("quote_asset")
    private String quoteAsset;
    private int status;
    private String symbol;
    @SerializedName("trade_avg_price")
    private String tradeAvgPrice;
    @SerializedName("trade_partition")
    private String tradePartition;
    @SerializedName("trade_turnover")
    private String tradeTurnover;
    @SerializedName("trade_volume")
    private String tradeVolume;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionOrderInfo)) {
            return false;
        }
        OptionOrderInfo optionOrderInfo = (OptionOrderInfo) obj;
        if (!optionOrderInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = optionOrderInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = optionOrderInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = optionOrderInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String optionCode2 = getOptionCode();
        String optionCode3 = optionOrderInfo.getOptionCode();
        if (optionCode2 != null ? !optionCode2.equals(optionCode3) : optionCode3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = optionOrderInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = optionOrderInfo.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = optionOrderInfo.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        if (getOrderType() != optionOrderInfo.getOrderType()) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = optionOrderInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = optionOrderInfo.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        if (getOrderId() != optionOrderInfo.getOrderId()) {
            return false;
        }
        String orderIdStr2 = getOrderIdStr();
        String orderIdStr3 = optionOrderInfo.getOrderIdStr();
        if (orderIdStr2 != null ? !orderIdStr2.equals(orderIdStr3) : orderIdStr3 != null) {
            return false;
        }
        if (getClientOrderId() != optionOrderInfo.getClientOrderId() || getCreatedAt() != optionOrderInfo.getCreatedAt()) {
            return false;
        }
        String tradeVolume2 = getTradeVolume();
        String tradeVolume3 = optionOrderInfo.getTradeVolume();
        if (tradeVolume2 != null ? !tradeVolume2.equals(tradeVolume3) : tradeVolume3 != null) {
            return false;
        }
        String tradeTurnover2 = getTradeTurnover();
        String tradeTurnover3 = optionOrderInfo.getTradeTurnover();
        if (tradeTurnover2 != null ? !tradeTurnover2.equals(tradeTurnover3) : tradeTurnover3 != null) {
            return false;
        }
        String fee2 = getFee();
        String fee3 = optionOrderInfo.getFee();
        if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
            return false;
        }
        String feeAsset2 = getFeeAsset();
        String feeAsset3 = optionOrderInfo.getFeeAsset();
        if (feeAsset2 != null ? !feeAsset2.equals(feeAsset3) : feeAsset3 != null) {
            return false;
        }
        String tradeAvgPrice2 = getTradeAvgPrice();
        String tradeAvgPrice3 = optionOrderInfo.getTradeAvgPrice();
        if (tradeAvgPrice2 != null ? !tradeAvgPrice2.equals(tradeAvgPrice3) : tradeAvgPrice3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = optionOrderInfo.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = optionOrderInfo.getProfit();
        if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
            return false;
        }
        if (getStatus() != optionOrderInfo.getStatus()) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = optionOrderInfo.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        String deliveryDate2 = getDeliveryDate();
        String deliveryDate3 = optionOrderInfo.getDeliveryDate();
        if (deliveryDate2 != null ? !deliveryDate2.equals(deliveryDate3) : deliveryDate3 != null) {
            return false;
        }
        String optionRightType2 = getOptionRightType();
        String optionRightType3 = optionOrderInfo.getOptionRightType();
        if (optionRightType2 != null ? !optionRightType2.equals(optionRightType3) : optionRightType3 != null) {
            return false;
        }
        String exercisePrice2 = getExercisePrice();
        String exercisePrice3 = optionOrderInfo.getExercisePrice();
        if (exercisePrice2 != null ? !exercisePrice2.equals(exercisePrice3) : exercisePrice3 != null) {
            return false;
        }
        String quoteAsset2 = getQuoteAsset();
        String quoteAsset3 = optionOrderInfo.getQuoteAsset();
        if (quoteAsset2 != null ? !quoteAsset2.equals(quoteAsset3) : quoteAsset3 != null) {
            return false;
        }
        String frozenPremium2 = getFrozenPremium();
        String frozenPremium3 = optionOrderInfo.getFrozenPremium();
        if (frozenPremium2 != null ? !frozenPremium2.equals(frozenPremium3) : frozenPremium3 != null) {
            return false;
        }
        String feeFrozen2 = getFeeFrozen();
        String feeFrozen3 = optionOrderInfo.getFeeFrozen();
        return feeFrozen2 != null ? feeFrozen2.equals(feeFrozen3) : feeFrozen3 == null;
    }

    public long getClientOrderId() {
        return this.clientOrderId;
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

    public String getDeliveryDate() {
        return this.deliveryDate;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getExercisePrice() {
        return this.exercisePrice;
    }

    public String getFee() {
        return this.fee;
    }

    public String getFeeAsset() {
        return this.feeAsset;
    }

    public String getFeeFrozen() {
        return this.feeFrozen;
    }

    public String getFrozenPremium() {
        return this.frozenPremium;
    }

    public String getMarginFrozen() {
        return this.marginFrozen;
    }

    public String getOffset() {
        return this.offset;
    }

    public String getOptionCode() {
        return this.optionCode;
    }

    public String getOptionRightType() {
        return this.optionRightType;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public String getOrderIdStr() {
        return this.orderIdStr;
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

    public String getPrice() {
        return this.price;
    }

    public String getProfit() {
        return this.profit;
    }

    public String getQuoteAsset() {
        return this.quoteAsset;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradeAvgPrice() {
        return this.tradeAvgPrice;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public String getTradeTurnover() {
        return this.tradeTurnover;
    }

    public String getTradeVolume() {
        return this.tradeVolume;
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
        String volume2 = getVolume();
        int hashCode6 = (hashCode5 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String price2 = getPrice();
        int hashCode7 = (hashCode6 * 59) + (price2 == null ? 43 : price2.hashCode());
        String orderPriceType2 = getOrderPriceType();
        int hashCode8 = (((hashCode7 * 59) + (orderPriceType2 == null ? 43 : orderPriceType2.hashCode())) * 59) + getOrderType();
        String direction2 = getDirection();
        int hashCode9 = (hashCode8 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode10 = (hashCode9 * 59) + (offset2 == null ? 43 : offset2.hashCode());
        long orderId2 = getOrderId();
        int i12 = (hashCode10 * 59) + ((int) (orderId2 ^ (orderId2 >>> 32)));
        String orderIdStr2 = getOrderIdStr();
        int hashCode11 = (i12 * 59) + (orderIdStr2 == null ? 43 : orderIdStr2.hashCode());
        long clientOrderId2 = getClientOrderId();
        int i13 = (hashCode11 * 59) + ((int) (clientOrderId2 ^ (clientOrderId2 >>> 32)));
        long createdAt2 = getCreatedAt();
        int i14 = (i13 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String tradeVolume2 = getTradeVolume();
        int hashCode12 = (i14 * 59) + (tradeVolume2 == null ? 43 : tradeVolume2.hashCode());
        String tradeTurnover2 = getTradeTurnover();
        int hashCode13 = (hashCode12 * 59) + (tradeTurnover2 == null ? 43 : tradeTurnover2.hashCode());
        String fee2 = getFee();
        int hashCode14 = (hashCode13 * 59) + (fee2 == null ? 43 : fee2.hashCode());
        String feeAsset2 = getFeeAsset();
        int hashCode15 = (hashCode14 * 59) + (feeAsset2 == null ? 43 : feeAsset2.hashCode());
        String tradeAvgPrice2 = getTradeAvgPrice();
        int hashCode16 = (hashCode15 * 59) + (tradeAvgPrice2 == null ? 43 : tradeAvgPrice2.hashCode());
        String marginFrozen2 = getMarginFrozen();
        int hashCode17 = (hashCode16 * 59) + (marginFrozen2 == null ? 43 : marginFrozen2.hashCode());
        String profit2 = getProfit();
        int hashCode18 = (((hashCode17 * 59) + (profit2 == null ? 43 : profit2.hashCode())) * 59) + getStatus();
        String orderSource2 = getOrderSource();
        int hashCode19 = (hashCode18 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        String deliveryDate2 = getDeliveryDate();
        int hashCode20 = (hashCode19 * 59) + (deliveryDate2 == null ? 43 : deliveryDate2.hashCode());
        String optionRightType2 = getOptionRightType();
        int hashCode21 = (hashCode20 * 59) + (optionRightType2 == null ? 43 : optionRightType2.hashCode());
        String exercisePrice2 = getExercisePrice();
        int hashCode22 = (hashCode21 * 59) + (exercisePrice2 == null ? 43 : exercisePrice2.hashCode());
        String quoteAsset2 = getQuoteAsset();
        int hashCode23 = (hashCode22 * 59) + (quoteAsset2 == null ? 43 : quoteAsset2.hashCode());
        String frozenPremium2 = getFrozenPremium();
        int hashCode24 = (hashCode23 * 59) + (frozenPremium2 == null ? 43 : frozenPremium2.hashCode());
        String feeFrozen2 = getFeeFrozen();
        int i15 = hashCode24 * 59;
        if (feeFrozen2 != null) {
            i11 = feeFrozen2.hashCode();
        }
        return i15 + i11;
    }

    public boolean isBuy() {
        return "buy".equals(getDirection());
    }

    public boolean isDelivery() {
        return "settlement".equals(getOrderSource());
    }

    public boolean isOpen() {
        return "open".equals(getOffset());
    }

    public boolean isRiseType() {
        return "C".equals(getOptionRightType());
    }

    public void setClientOrderId(long j11) {
        this.clientOrderId = j11;
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

    public void setDeliveryDate(String str) {
        this.deliveryDate = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setExercisePrice(String str) {
        this.exercisePrice = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setFeeAsset(String str) {
        this.feeAsset = str;
    }

    public void setFeeFrozen(String str) {
        this.feeFrozen = str;
    }

    public void setFrozenPremium(String str) {
        this.frozenPremium = str;
    }

    public void setMarginFrozen(String str) {
        this.marginFrozen = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOptionCode(String str) {
        this.optionCode = str;
    }

    public void setOptionRightType(String str) {
        this.optionRightType = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setOrderIdStr(String str) {
        this.orderIdStr = str;
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

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setQuoteAsset(String str) {
        this.quoteAsset = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeAvgPrice(String str) {
        this.tradeAvgPrice = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public void setTradeTurnover(String str) {
        this.tradeTurnover = str;
    }

    public void setTradeVolume(String str) {
        this.tradeVolume = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "OptionOrderInfo(symbol=" + getSymbol() + ", tradePartition=" + getTradePartition() + ", contractType=" + getContractType() + ", contractCode=" + getContractCode() + ", optionCode=" + getOptionCode() + ", volume=" + getVolume() + ", price=" + getPrice() + ", orderPriceType=" + getOrderPriceType() + ", orderType=" + getOrderType() + ", direction=" + getDirection() + ", offset=" + getOffset() + ", orderId=" + getOrderId() + ", orderIdStr=" + getOrderIdStr() + ", clientOrderId=" + getClientOrderId() + ", createdAt=" + getCreatedAt() + ", tradeVolume=" + getTradeVolume() + ", tradeTurnover=" + getTradeTurnover() + ", fee=" + getFee() + ", feeAsset=" + getFeeAsset() + ", tradeAvgPrice=" + getTradeAvgPrice() + ", marginFrozen=" + getMarginFrozen() + ", profit=" + getProfit() + ", status=" + getStatus() + ", orderSource=" + getOrderSource() + ", deliveryDate=" + getDeliveryDate() + ", optionRightType=" + getOptionRightType() + ", exercisePrice=" + getExercisePrice() + ", quoteAsset=" + getQuoteAsset() + ", frozenPremium=" + getFrozenPremium() + ", feeFrozen=" + getFeeFrozen() + ", contractFace=" + getContractFace() + ")";
    }
}
