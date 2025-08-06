package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import com.huobi.contract.viewhandler.ContractHistoryOrderHandler;
import java.io.Serializable;
import s9.a;

public class ContractHistoryOrderInfo implements Serializable, a {
    public static final int STATUS_CANCELED = 7;
    private static final long serialVersionUID = 3700023261204599385L;
    @SerializedName("contract_code")
    private String contractCode;
    private String contractFace;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("create_date")
    private Long createDate;
    private String direction;
    private String fee;
    private boolean hasDetail;
    @SerializedName("lever_rate")
    private Integer leverRate;
    @SerializedName("liquidation_type")
    private String liquidationType;
    @SerializedName("margin_frozen")
    private String marginFrozen;
    private String offset;
    @SerializedName("order_id")
    private Long orderId;
    @SerializedName("order_price_type")
    private String orderPriceType;
    @SerializedName("order_source")
    private String orderSource;
    @SerializedName("order_type")
    private int orderType;
    private String price;
    private String profit;
    private int status;
    private String symbol;
    @SerializedName("trade_avg_price")
    private String tradeAvgPrice;
    @SerializedName("trade_turnover")
    private String tradeTurnover;
    @SerializedName("trade_volume")
    private String tradeVolume;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractHistoryOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractHistoryOrderInfo)) {
            return false;
        }
        ContractHistoryOrderInfo contractHistoryOrderInfo = (ContractHistoryOrderInfo) obj;
        if (!contractHistoryOrderInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractHistoryOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractHistoryOrderInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractHistoryOrderInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = contractHistoryOrderInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = contractHistoryOrderInfo.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = contractHistoryOrderInfo.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        if (getOrderType() != contractHistoryOrderInfo.getOrderType()) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = contractHistoryOrderInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = contractHistoryOrderInfo.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        Integer leverRate2 = getLeverRate();
        Integer leverRate3 = contractHistoryOrderInfo.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        Long orderId2 = getOrderId();
        Long orderId3 = contractHistoryOrderInfo.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        Long createDate2 = getCreateDate();
        Long createDate3 = contractHistoryOrderInfo.getCreateDate();
        if (createDate2 != null ? !createDate2.equals(createDate3) : createDate3 != null) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = contractHistoryOrderInfo.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        String tradeVolume2 = getTradeVolume();
        String tradeVolume3 = contractHistoryOrderInfo.getTradeVolume();
        if (tradeVolume2 != null ? !tradeVolume2.equals(tradeVolume3) : tradeVolume3 != null) {
            return false;
        }
        String tradeTurnover2 = getTradeTurnover();
        String tradeTurnover3 = contractHistoryOrderInfo.getTradeTurnover();
        if (tradeTurnover2 != null ? !tradeTurnover2.equals(tradeTurnover3) : tradeTurnover3 != null) {
            return false;
        }
        String fee2 = getFee();
        String fee3 = contractHistoryOrderInfo.getFee();
        if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
            return false;
        }
        String tradeAvgPrice2 = getTradeAvgPrice();
        String tradeAvgPrice3 = contractHistoryOrderInfo.getTradeAvgPrice();
        if (tradeAvgPrice2 != null ? !tradeAvgPrice2.equals(tradeAvgPrice3) : tradeAvgPrice3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = contractHistoryOrderInfo.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = contractHistoryOrderInfo.getProfit();
        if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
            return false;
        }
        if (getStatus() != contractHistoryOrderInfo.getStatus()) {
            return false;
        }
        String contractFace2 = getContractFace();
        String contractFace3 = contractHistoryOrderInfo.getContractFace();
        if (contractFace2 != null ? !contractFace2.equals(contractFace3) : contractFace3 != null) {
            return false;
        }
        if (isHasDetail() != contractHistoryOrderInfo.isHasDetail()) {
            return false;
        }
        String liquidationType2 = getLiquidationType();
        String liquidationType3 = contractHistoryOrderInfo.getLiquidationType();
        return liquidationType2 != null ? liquidationType2.equals(liquidationType3) : liquidationType3 == null;
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

    public Long getCreateDate() {
        return this.createDate;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFee() {
        return this.fee;
    }

    public Integer getLeverRate() {
        return this.leverRate;
    }

    public String getLiquidationType() {
        return this.liquidationType;
    }

    public String getMarginFrozen() {
        return this.marginFrozen;
    }

    public String getOffset() {
        return this.offset;
    }

    public Long getOrderId() {
        return this.orderId;
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

    public int getStatus() {
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

    public String getViewHandlerName() {
        return ContractHistoryOrderHandler.class.getName();
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
        int hashCode6 = (((hashCode5 * 59) + (orderPriceType2 == null ? 43 : orderPriceType2.hashCode())) * 59) + getOrderType();
        String direction2 = getDirection();
        int hashCode7 = (hashCode6 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode8 = (hashCode7 * 59) + (offset2 == null ? 43 : offset2.hashCode());
        Integer leverRate2 = getLeverRate();
        int hashCode9 = (hashCode8 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
        Long orderId2 = getOrderId();
        int hashCode10 = (hashCode9 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
        Long createDate2 = getCreateDate();
        int hashCode11 = (hashCode10 * 59) + (createDate2 == null ? 43 : createDate2.hashCode());
        String orderSource2 = getOrderSource();
        int hashCode12 = (hashCode11 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        String tradeVolume2 = getTradeVolume();
        int hashCode13 = (hashCode12 * 59) + (tradeVolume2 == null ? 43 : tradeVolume2.hashCode());
        String tradeTurnover2 = getTradeTurnover();
        int hashCode14 = (hashCode13 * 59) + (tradeTurnover2 == null ? 43 : tradeTurnover2.hashCode());
        String fee2 = getFee();
        int hashCode15 = (hashCode14 * 59) + (fee2 == null ? 43 : fee2.hashCode());
        String tradeAvgPrice2 = getTradeAvgPrice();
        int hashCode16 = (hashCode15 * 59) + (tradeAvgPrice2 == null ? 43 : tradeAvgPrice2.hashCode());
        String marginFrozen2 = getMarginFrozen();
        int hashCode17 = (hashCode16 * 59) + (marginFrozen2 == null ? 43 : marginFrozen2.hashCode());
        String profit2 = getProfit();
        int hashCode18 = (((hashCode17 * 59) + (profit2 == null ? 43 : profit2.hashCode())) * 59) + getStatus();
        String contractFace2 = getContractFace();
        int hashCode19 = (((hashCode18 * 59) + (contractFace2 == null ? 43 : contractFace2.hashCode())) * 59) + (isHasDetail() ? 79 : 97);
        String liquidationType2 = getLiquidationType();
        int i12 = hashCode19 * 59;
        if (liquidationType2 != null) {
            i11 = liquidationType2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isBuy() {
        return "buy".equals(getDirection());
    }

    public boolean isCanceled() {
        return this.status == 7;
    }

    public boolean isDelivery() {
        return "settlement".equals(getOrderSource());
    }

    public boolean isExplose() {
        return "risk".equals(getOrderSource());
    }

    public boolean isHasDetail() {
        return this.hasDetail;
    }

    public boolean isLiquidationExplose() {
        return "1".equalsIgnoreCase(getLiquidationType()) || "2".equalsIgnoreCase(getLiquidationType()) || "3".equalsIgnoreCase(getLiquidationType());
    }

    public boolean isOpen() {
        return "open".equals(getOffset());
    }

    public boolean isQuestionExplose() {
        return "1".equalsIgnoreCase(getLiquidationType()) || "2".equalsIgnoreCase(getLiquidationType()) || "3".equalsIgnoreCase(getLiquidationType()) || "4".equalsIgnoreCase(getLiquidationType());
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

    public void setCreateDate(Long l11) {
        this.createDate = l11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setHasDetail(boolean z11) {
        this.hasDetail = z11;
    }

    public void setLeverRate(Integer num) {
        this.leverRate = num;
    }

    public void setLiquidationType(String str) {
        this.liquidationType = str;
    }

    public void setMarginFrozen(String str) {
        this.marginFrozen = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOrderId(Long l11) {
        this.orderId = l11;
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

    public void setStatus(int i11) {
        this.status = i11;
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
        return "ContractHistoryOrderInfo{symbol='" + this.symbol + '\'' + ", contractType='" + this.contractType + '\'' + ", contractCode='" + this.contractCode + '\'' + ", volume='" + this.volume + '\'' + ", price='" + this.price + '\'' + ", orderPriceType='" + this.orderPriceType + '\'' + ", orderType=" + this.orderType + ", direction='" + this.direction + '\'' + ", offset='" + this.offset + '\'' + ", leverRate=" + this.leverRate + ", orderId=" + this.orderId + ", createDate=" + this.createDate + ", orderSource='" + this.orderSource + '\'' + ", tradeVolume='" + this.tradeVolume + '\'' + ", tradeTurnover='" + this.tradeTurnover + '\'' + ", fee='" + this.fee + '\'' + ", tradeAvgPrice='" + this.tradeAvgPrice + '\'' + ", marginFrozen='" + this.marginFrozen + '\'' + ", profit='" + this.profit + '\'' + ", status=" + this.status + ", contractFace='" + this.contractFace + '\'' + ", hasDetail=" + this.hasDetail + ", liquidationType=" + this.liquidationType + '}';
    }
}
