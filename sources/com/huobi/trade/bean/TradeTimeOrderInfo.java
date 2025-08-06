package com.huobi.trade.bean;

import java.io.Serializable;

public class TradeTimeOrderInfo implements Serializable {
    public static final String DEFAULT_VALUE = "--";
    private String accountId = "";
    private int delegateType;
    private int direction = 0;
    private String displayOrderAmountValue = "";
    private String displayOrderIntervalValue = "";
    private String displayOrderOneAmountValue = "";
    private String displayOrderPriceRangeValue = "";
    private String displayOrderPriceValue = "";
    private String displayOrderTypeValue = "";
    private String interval;
    private String orderPrice;
    private String orderPriceGap;
    private String orderPriceRatio;
    private int orderPriceType = 0;
    private String orderSide;
    private String orderSize;
    private String orderType;
    private String singleOrderRatio;
    private String singleOrderSize;
    private int singleOrderType = 0;
    private String source = "android";
    private String symbol = "--";
    private String symbolName;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public TradeTimeOrderInfo f81967a = new TradeTimeOrderInfo();
    }

    public boolean canEqual(Object obj) {
        return obj instanceof TradeTimeOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeTimeOrderInfo)) {
            return false;
        }
        TradeTimeOrderInfo tradeTimeOrderInfo = (TradeTimeOrderInfo) obj;
        if (!tradeTimeOrderInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = tradeTimeOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String symbolName2 = getSymbolName();
        String symbolName3 = tradeTimeOrderInfo.getSymbolName();
        if (symbolName2 != null ? !symbolName2.equals(symbolName3) : symbolName3 != null) {
            return false;
        }
        if (getDirection() != tradeTimeOrderInfo.getDirection()) {
            return false;
        }
        String accountId2 = getAccountId();
        String accountId3 = tradeTimeOrderInfo.getAccountId();
        if (accountId2 != null ? !accountId2.equals(accountId3) : accountId3 != null) {
            return false;
        }
        String source2 = getSource();
        String source3 = tradeTimeOrderInfo.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        if (getOrderPriceType() != tradeTimeOrderInfo.getOrderPriceType() || getSingleOrderType() != tradeTimeOrderInfo.getSingleOrderType()) {
            return false;
        }
        String orderType2 = getOrderType();
        String orderType3 = tradeTimeOrderInfo.getOrderType();
        if (orderType2 != null ? !orderType2.equals(orderType3) : orderType3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = tradeTimeOrderInfo.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        String orderSize2 = getOrderSize();
        String orderSize3 = tradeTimeOrderInfo.getOrderSize();
        if (orderSize2 != null ? !orderSize2.equals(orderSize3) : orderSize3 != null) {
            return false;
        }
        if (getDelegateType() != tradeTimeOrderInfo.getDelegateType()) {
            return false;
        }
        String orderPriceRatio2 = getOrderPriceRatio();
        String orderPriceRatio3 = tradeTimeOrderInfo.getOrderPriceRatio();
        if (orderPriceRatio2 != null ? !orderPriceRatio2.equals(orderPriceRatio3) : orderPriceRatio3 != null) {
            return false;
        }
        String orderPriceGap2 = getOrderPriceGap();
        String orderPriceGap3 = tradeTimeOrderInfo.getOrderPriceGap();
        if (orderPriceGap2 != null ? !orderPriceGap2.equals(orderPriceGap3) : orderPriceGap3 != null) {
            return false;
        }
        String singleOrderSize2 = getSingleOrderSize();
        String singleOrderSize3 = tradeTimeOrderInfo.getSingleOrderSize();
        if (singleOrderSize2 != null ? !singleOrderSize2.equals(singleOrderSize3) : singleOrderSize3 != null) {
            return false;
        }
        String singleOrderRatio2 = getSingleOrderRatio();
        String singleOrderRatio3 = tradeTimeOrderInfo.getSingleOrderRatio();
        if (singleOrderRatio2 != null ? !singleOrderRatio2.equals(singleOrderRatio3) : singleOrderRatio3 != null) {
            return false;
        }
        String interval2 = getInterval();
        String interval3 = tradeTimeOrderInfo.getInterval();
        if (interval2 != null ? !interval2.equals(interval3) : interval3 != null) {
            return false;
        }
        String orderSide2 = getOrderSide();
        String orderSide3 = tradeTimeOrderInfo.getOrderSide();
        if (orderSide2 != null ? !orderSide2.equals(orderSide3) : orderSide3 != null) {
            return false;
        }
        String displayOrderTypeValue2 = getDisplayOrderTypeValue();
        String displayOrderTypeValue3 = tradeTimeOrderInfo.getDisplayOrderTypeValue();
        if (displayOrderTypeValue2 != null ? !displayOrderTypeValue2.equals(displayOrderTypeValue3) : displayOrderTypeValue3 != null) {
            return false;
        }
        String displayOrderPriceValue2 = getDisplayOrderPriceValue();
        String displayOrderPriceValue3 = tradeTimeOrderInfo.getDisplayOrderPriceValue();
        if (displayOrderPriceValue2 != null ? !displayOrderPriceValue2.equals(displayOrderPriceValue3) : displayOrderPriceValue3 != null) {
            return false;
        }
        String displayOrderPriceRangeValue2 = getDisplayOrderPriceRangeValue();
        String displayOrderPriceRangeValue3 = tradeTimeOrderInfo.getDisplayOrderPriceRangeValue();
        if (displayOrderPriceRangeValue2 != null ? !displayOrderPriceRangeValue2.equals(displayOrderPriceRangeValue3) : displayOrderPriceRangeValue3 != null) {
            return false;
        }
        String displayOrderAmountValue2 = getDisplayOrderAmountValue();
        String displayOrderAmountValue3 = tradeTimeOrderInfo.getDisplayOrderAmountValue();
        if (displayOrderAmountValue2 != null ? !displayOrderAmountValue2.equals(displayOrderAmountValue3) : displayOrderAmountValue3 != null) {
            return false;
        }
        String displayOrderOneAmountValue2 = getDisplayOrderOneAmountValue();
        String displayOrderOneAmountValue3 = tradeTimeOrderInfo.getDisplayOrderOneAmountValue();
        if (displayOrderOneAmountValue2 != null ? !displayOrderOneAmountValue2.equals(displayOrderOneAmountValue3) : displayOrderOneAmountValue3 != null) {
            return false;
        }
        String displayOrderIntervalValue2 = getDisplayOrderIntervalValue();
        String displayOrderIntervalValue3 = tradeTimeOrderInfo.getDisplayOrderIntervalValue();
        return displayOrderIntervalValue2 != null ? displayOrderIntervalValue2.equals(displayOrderIntervalValue3) : displayOrderIntervalValue3 == null;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public int getDelegateType() {
        return this.delegateType;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getDisplayOrderAmountValue() {
        return this.displayOrderAmountValue;
    }

    public String getDisplayOrderIntervalValue() {
        return this.displayOrderIntervalValue;
    }

    public String getDisplayOrderOneAmountValue() {
        return this.displayOrderOneAmountValue;
    }

    public String getDisplayOrderPriceRangeValue() {
        return this.displayOrderPriceRangeValue;
    }

    public String getDisplayOrderPriceValue() {
        return this.displayOrderPriceValue;
    }

    public String getDisplayOrderTypeValue() {
        return this.displayOrderTypeValue;
    }

    public String getInterval() {
        return this.interval;
    }

    public String getOrderPrice() {
        return this.orderPrice;
    }

    public String getOrderPriceGap() {
        return this.orderPriceGap;
    }

    public String getOrderPriceRatio() {
        return this.orderPriceRatio;
    }

    public int getOrderPriceType() {
        return this.orderPriceType;
    }

    public String getOrderSide() {
        return this.orderSide;
    }

    public String getOrderSize() {
        return this.orderSize;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public String getSingleOrderRatio() {
        return this.singleOrderRatio;
    }

    public String getSingleOrderSize() {
        return this.singleOrderSize;
    }

    public int getSingleOrderType() {
        return this.singleOrderType;
    }

    public String getSource() {
        return this.source;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getSymbolName() {
        return this.symbolName;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String symbolName2 = getSymbolName();
        int hashCode2 = ((((hashCode + 59) * 59) + (symbolName2 == null ? 43 : symbolName2.hashCode())) * 59) + getDirection();
        String accountId2 = getAccountId();
        int hashCode3 = (hashCode2 * 59) + (accountId2 == null ? 43 : accountId2.hashCode());
        String source2 = getSource();
        int hashCode4 = (((((hashCode3 * 59) + (source2 == null ? 43 : source2.hashCode())) * 59) + getOrderPriceType()) * 59) + getSingleOrderType();
        String orderType2 = getOrderType();
        int hashCode5 = (hashCode4 * 59) + (orderType2 == null ? 43 : orderType2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode6 = (hashCode5 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        String orderSize2 = getOrderSize();
        int hashCode7 = (((hashCode6 * 59) + (orderSize2 == null ? 43 : orderSize2.hashCode())) * 59) + getDelegateType();
        String orderPriceRatio2 = getOrderPriceRatio();
        int hashCode8 = (hashCode7 * 59) + (orderPriceRatio2 == null ? 43 : orderPriceRatio2.hashCode());
        String orderPriceGap2 = getOrderPriceGap();
        int hashCode9 = (hashCode8 * 59) + (orderPriceGap2 == null ? 43 : orderPriceGap2.hashCode());
        String singleOrderSize2 = getSingleOrderSize();
        int hashCode10 = (hashCode9 * 59) + (singleOrderSize2 == null ? 43 : singleOrderSize2.hashCode());
        String singleOrderRatio2 = getSingleOrderRatio();
        int hashCode11 = (hashCode10 * 59) + (singleOrderRatio2 == null ? 43 : singleOrderRatio2.hashCode());
        String interval2 = getInterval();
        int hashCode12 = (hashCode11 * 59) + (interval2 == null ? 43 : interval2.hashCode());
        String orderSide2 = getOrderSide();
        int hashCode13 = (hashCode12 * 59) + (orderSide2 == null ? 43 : orderSide2.hashCode());
        String displayOrderTypeValue2 = getDisplayOrderTypeValue();
        int hashCode14 = (hashCode13 * 59) + (displayOrderTypeValue2 == null ? 43 : displayOrderTypeValue2.hashCode());
        String displayOrderPriceValue2 = getDisplayOrderPriceValue();
        int hashCode15 = (hashCode14 * 59) + (displayOrderPriceValue2 == null ? 43 : displayOrderPriceValue2.hashCode());
        String displayOrderPriceRangeValue2 = getDisplayOrderPriceRangeValue();
        int hashCode16 = (hashCode15 * 59) + (displayOrderPriceRangeValue2 == null ? 43 : displayOrderPriceRangeValue2.hashCode());
        String displayOrderAmountValue2 = getDisplayOrderAmountValue();
        int hashCode17 = (hashCode16 * 59) + (displayOrderAmountValue2 == null ? 43 : displayOrderAmountValue2.hashCode());
        String displayOrderOneAmountValue2 = getDisplayOrderOneAmountValue();
        int hashCode18 = (hashCode17 * 59) + (displayOrderOneAmountValue2 == null ? 43 : displayOrderOneAmountValue2.hashCode());
        String displayOrderIntervalValue2 = getDisplayOrderIntervalValue();
        int i12 = hashCode18 * 59;
        if (displayOrderIntervalValue2 != null) {
            i11 = displayOrderIntervalValue2.hashCode();
        }
        return i12 + i11;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setDelegateType(int i11) {
        this.delegateType = i11;
    }

    public void setDirection(int i11) {
        this.direction = i11;
    }

    public void setDisplayOrderAmountValue(String str) {
        this.displayOrderAmountValue = str;
    }

    public void setDisplayOrderIntervalValue(String str) {
        this.displayOrderIntervalValue = str;
    }

    public void setDisplayOrderOneAmountValue(String str) {
        this.displayOrderOneAmountValue = str;
    }

    public void setDisplayOrderPriceRangeValue(String str) {
        this.displayOrderPriceRangeValue = str;
    }

    public void setDisplayOrderPriceValue(String str) {
        this.displayOrderPriceValue = str;
    }

    public void setDisplayOrderTypeValue(String str) {
        this.displayOrderTypeValue = str;
    }

    public void setInterval(String str) {
        this.interval = str;
    }

    public void setOrderPrice(String str) {
        this.orderPrice = str;
    }

    public void setOrderPriceGap(String str) {
        this.orderPriceGap = str;
    }

    public void setOrderPriceRatio(String str) {
        this.orderPriceRatio = str;
    }

    public void setOrderPriceType(int i11) {
        this.orderPriceType = i11;
    }

    public void setOrderSide(String str) {
        this.orderSide = str;
    }

    public void setOrderSize(String str) {
        this.orderSize = str;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public void setSingleOrderRatio(String str) {
        this.singleOrderRatio = str;
    }

    public void setSingleOrderSize(String str) {
        this.singleOrderSize = str;
    }

    public void setSingleOrderType(int i11) {
        this.singleOrderType = i11;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setSymbolName(String str) {
        this.symbolName = str;
    }

    public String toString() {
        return "TradeTimeOrderInfo(symbol=" + getSymbol() + ", symbolName=" + getSymbolName() + ", direction=" + getDirection() + ", accountId=" + getAccountId() + ", source=" + getSource() + ", orderPriceType=" + getOrderPriceType() + ", singleOrderType=" + getSingleOrderType() + ", orderType=" + getOrderType() + ", orderPrice=" + getOrderPrice() + ", orderSize=" + getOrderSize() + ", delegateType=" + getDelegateType() + ", orderPriceRatio=" + getOrderPriceRatio() + ", orderPriceGap=" + getOrderPriceGap() + ", singleOrderSize=" + getSingleOrderSize() + ", singleOrderRatio=" + getSingleOrderRatio() + ", interval=" + getInterval() + ", orderSide=" + getOrderSide() + ", displayOrderTypeValue=" + getDisplayOrderTypeValue() + ", displayOrderPriceValue=" + getDisplayOrderPriceValue() + ", displayOrderPriceRangeValue=" + getDisplayOrderPriceRangeValue() + ", displayOrderAmountValue=" + getDisplayOrderAmountValue() + ", displayOrderOneAmountValue=" + getDisplayOrderOneAmountValue() + ", displayOrderIntervalValue=" + getDisplayOrderIntervalValue() + ")";
    }
}
