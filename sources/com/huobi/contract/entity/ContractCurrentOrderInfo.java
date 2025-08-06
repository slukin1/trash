package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractCurrentOrderInfo implements Serializable {
    public static final String ORDER_DIRECTION_BUY = "buy";
    public static final String ORDER_DIRECTION_SELL = "sell";
    public static final String ORDER_OFFSET_CLOSE = "close";
    public static final String ORDER_OFFSET_OPEN = "open";
    private static final long serialVersionUID = 3700023261204599385L;
    @SerializedName("client_order_id")
    private Long clientOrderId;
    @SerializedName("contract_code")
    private String contractCode;
    private transient String contractFace;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("created_at")
    private Long createdAt;
    private String direction;
    private String fee;
    @SerializedName("is_tpsl")
    private int isTpsl;
    @SerializedName("lever_rate")
    private Integer leverRate;
    @SerializedName("margin_frozen")
    private String marginFrozen;
    private String offset;
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("order_price_type")
    private String orderPriceType;
    @SerializedName("order_source")
    private String orderSource;
    private String price;
    private String profit;
    @SerializedName("real_profit")
    private String realProfit;
    private String status;
    private String symbol;
    @SerializedName("trade_avg_price")
    private String tradeAvgPrice;
    @SerializedName("trade_turnover")
    private String tradeTurnover;
    @SerializedName("trade_volume")
    private String tradeVolume;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractCurrentOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCurrentOrderInfo)) {
            return false;
        }
        ContractCurrentOrderInfo contractCurrentOrderInfo = (ContractCurrentOrderInfo) obj;
        if (!contractCurrentOrderInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractCurrentOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractCurrentOrderInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractCurrentOrderInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = contractCurrentOrderInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = contractCurrentOrderInfo.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = contractCurrentOrderInfo.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = contractCurrentOrderInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = contractCurrentOrderInfo.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        Integer leverRate2 = getLeverRate();
        Integer leverRate3 = contractCurrentOrderInfo.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = contractCurrentOrderInfo.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        Long clientOrderId2 = getClientOrderId();
        Long clientOrderId3 = contractCurrentOrderInfo.getClientOrderId();
        if (clientOrderId2 != null ? !clientOrderId2.equals(clientOrderId3) : clientOrderId3 != null) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = contractCurrentOrderInfo.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        Long createdAt2 = getCreatedAt();
        Long createdAt3 = contractCurrentOrderInfo.getCreatedAt();
        if (createdAt2 != null ? !createdAt2.equals(createdAt3) : createdAt3 != null) {
            return false;
        }
        String tradeVolume2 = getTradeVolume();
        String tradeVolume3 = contractCurrentOrderInfo.getTradeVolume();
        if (tradeVolume2 != null ? !tradeVolume2.equals(tradeVolume3) : tradeVolume3 != null) {
            return false;
        }
        String tradeTurnover2 = getTradeTurnover();
        String tradeTurnover3 = contractCurrentOrderInfo.getTradeTurnover();
        if (tradeTurnover2 != null ? !tradeTurnover2.equals(tradeTurnover3) : tradeTurnover3 != null) {
            return false;
        }
        String fee2 = getFee();
        String fee3 = contractCurrentOrderInfo.getFee();
        if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
            return false;
        }
        String tradeAvgPrice2 = getTradeAvgPrice();
        String tradeAvgPrice3 = contractCurrentOrderInfo.getTradeAvgPrice();
        if (tradeAvgPrice2 != null ? !tradeAvgPrice2.equals(tradeAvgPrice3) : tradeAvgPrice3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = contractCurrentOrderInfo.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = contractCurrentOrderInfo.getProfit();
        if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
            return false;
        }
        String realProfit2 = getRealProfit();
        String realProfit3 = contractCurrentOrderInfo.getRealProfit();
        if (realProfit2 != null ? !realProfit2.equals(realProfit3) : realProfit3 != null) {
            return false;
        }
        if (getIsTpsl() != contractCurrentOrderInfo.getIsTpsl()) {
            return false;
        }
        String status2 = getStatus();
        String status3 = contractCurrentOrderInfo.getStatus();
        return status2 != null ? status2.equals(status3) : status3 == null;
    }

    public Long getClientOrderId() {
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

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFee() {
        return this.fee;
    }

    public int getIsTpsl() {
        return this.isTpsl;
    }

    public Integer getLeverRate() {
        return this.leverRate;
    }

    public String getMarginFrozen() {
        return this.marginFrozen;
    }

    public String getOffset() {
        return this.offset;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrderPriceType() {
        return this.orderPriceType;
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProfit() {
        return this.profit;
    }

    public String getRealProfit() {
        return this.realProfit;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradeAvgPrice() {
        return this.tradeAvgPrice;
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
        String contractType2 = getContractType();
        int hashCode2 = ((hashCode + 59) * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode3 = (hashCode2 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String volume2 = getVolume();
        int hashCode4 = (hashCode3 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String price2 = getPrice();
        int hashCode5 = (hashCode4 * 59) + (price2 == null ? 43 : price2.hashCode());
        String orderPriceType2 = getOrderPriceType();
        int hashCode6 = (hashCode5 * 59) + (orderPriceType2 == null ? 43 : orderPriceType2.hashCode());
        String direction2 = getDirection();
        int hashCode7 = (hashCode6 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode8 = (hashCode7 * 59) + (offset2 == null ? 43 : offset2.hashCode());
        Integer leverRate2 = getLeverRate();
        int hashCode9 = (hashCode8 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
        String orderId2 = getOrderId();
        int hashCode10 = (hashCode9 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
        Long clientOrderId2 = getClientOrderId();
        int hashCode11 = (hashCode10 * 59) + (clientOrderId2 == null ? 43 : clientOrderId2.hashCode());
        String orderSource2 = getOrderSource();
        int hashCode12 = (hashCode11 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        Long createdAt2 = getCreatedAt();
        int hashCode13 = (hashCode12 * 59) + (createdAt2 == null ? 43 : createdAt2.hashCode());
        String tradeVolume2 = getTradeVolume();
        int hashCode14 = (hashCode13 * 59) + (tradeVolume2 == null ? 43 : tradeVolume2.hashCode());
        String tradeTurnover2 = getTradeTurnover();
        int hashCode15 = (hashCode14 * 59) + (tradeTurnover2 == null ? 43 : tradeTurnover2.hashCode());
        String fee2 = getFee();
        int hashCode16 = (hashCode15 * 59) + (fee2 == null ? 43 : fee2.hashCode());
        String tradeAvgPrice2 = getTradeAvgPrice();
        int hashCode17 = (hashCode16 * 59) + (tradeAvgPrice2 == null ? 43 : tradeAvgPrice2.hashCode());
        String marginFrozen2 = getMarginFrozen();
        int hashCode18 = (hashCode17 * 59) + (marginFrozen2 == null ? 43 : marginFrozen2.hashCode());
        String profit2 = getProfit();
        int hashCode19 = (hashCode18 * 59) + (profit2 == null ? 43 : profit2.hashCode());
        String realProfit2 = getRealProfit();
        int hashCode20 = (((hashCode19 * 59) + (realProfit2 == null ? 43 : realProfit2.hashCode())) * 59) + getIsTpsl();
        String status2 = getStatus();
        int i12 = hashCode20 * 59;
        if (status2 != null) {
            i11 = status2.hashCode();
        }
        return i12 + i11;
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

    public boolean isTpsl() {
        return this.isTpsl == 1;
    }

    public void setClientOrderId(Long l11) {
        this.clientOrderId = l11;
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

    public void setCreatedAt(Long l11) {
        this.createdAt = l11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setIsTpsl(int i11) {
        this.isTpsl = i11;
    }

    public void setLeverRate(Integer num) {
        this.leverRate = num;
    }

    public void setMarginFrozen(String str) {
        this.marginFrozen = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderPriceType(String str) {
        this.orderPriceType = str;
    }

    public void setOrderSource(String str) {
        this.orderSource = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setRealProfit(String str) {
        this.realProfit = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeAvgPrice(String str) {
        this.tradeAvgPrice = str;
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
        return "ContractCurrentOrderInfo{symbol='" + this.symbol + '\'' + ", contractType='" + this.contractType + '\'' + ", contractCode='" + this.contractCode + '\'' + ", volume='" + this.volume + '\'' + ", price='" + this.price + '\'' + ", orderPriceType='" + this.orderPriceType + '\'' + ", direction='" + this.direction + '\'' + ", offset='" + this.offset + '\'' + ", leverRate=" + this.leverRate + ", orderId=" + this.orderId + ", clientOrderId=" + this.clientOrderId + ", orderSource='" + this.orderSource + '\'' + ", createdAt=" + this.createdAt + ", tradeVolume=" + this.tradeVolume + ", tradeTurnover='" + this.tradeTurnover + '\'' + ", fee='" + this.fee + '\'' + ", tradeAvgPrice='" + this.tradeAvgPrice + '\'' + ", marginFrozen='" + this.marginFrozen + '\'' + ", status='" + this.status + '\'' + '}';
    }
}
