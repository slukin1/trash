package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class AlgoOrderInfo implements Serializable {
    private long accountId;
    private String clientOrderId;
    private int delegateType;
    private String errCode;
    private String errMessage;
    private String iceAmount;

    /* renamed from: id  reason: collision with root package name */
    private long f70607id;
    private String interval;
    private long lastActTime;
    private String operator;
    private long orderCreateTime;
    private String orderFinishSize;
    private long orderOrigTime;
    private String orderPrice;
    private String orderPriceGap;
    private String orderPriceRatio;
    private int orderPriceType;
    private String orderSide;
    private String orderSize;
    private String orderStatus;
    private String orderType;
    private String orderValue;
    private String singleOrderRatio;
    private String singleOrderSize;
    private int singleOrderType;
    private String source;
    private String stopPrice;
    private String symbol;
    private String timeInForce;

    public boolean canEqual(Object obj) {
        return obj instanceof AlgoOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlgoOrderInfo)) {
            return false;
        }
        AlgoOrderInfo algoOrderInfo = (AlgoOrderInfo) obj;
        if (!algoOrderInfo.canEqual(this) || getId() != algoOrderInfo.getId() || getAccountId() != algoOrderInfo.getAccountId()) {
            return false;
        }
        String source2 = getSource();
        String source3 = algoOrderInfo.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        String clientOrderId2 = getClientOrderId();
        String clientOrderId3 = algoOrderInfo.getClientOrderId();
        if (clientOrderId2 != null ? !clientOrderId2.equals(clientOrderId3) : clientOrderId3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = algoOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = algoOrderInfo.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        String orderSize2 = getOrderSize();
        String orderSize3 = algoOrderInfo.getOrderSize();
        if (orderSize2 != null ? !orderSize2.equals(orderSize3) : orderSize3 != null) {
            return false;
        }
        String orderValue2 = getOrderValue();
        String orderValue3 = algoOrderInfo.getOrderValue();
        if (orderValue2 != null ? !orderValue2.equals(orderValue3) : orderValue3 != null) {
            return false;
        }
        String orderSide2 = getOrderSide();
        String orderSide3 = algoOrderInfo.getOrderSide();
        if (orderSide2 != null ? !orderSide2.equals(orderSide3) : orderSide3 != null) {
            return false;
        }
        String timeInForce2 = getTimeInForce();
        String timeInForce3 = algoOrderInfo.getTimeInForce();
        if (timeInForce2 != null ? !timeInForce2.equals(timeInForce3) : timeInForce3 != null) {
            return false;
        }
        String orderType2 = getOrderType();
        String orderType3 = algoOrderInfo.getOrderType();
        if (orderType2 != null ? !orderType2.equals(orderType3) : orderType3 != null) {
            return false;
        }
        String stopPrice2 = getStopPrice();
        String stopPrice3 = algoOrderInfo.getStopPrice();
        if (stopPrice2 != null ? !stopPrice2.equals(stopPrice3) : stopPrice3 != null) {
            return false;
        }
        String operator2 = getOperator();
        String operator3 = algoOrderInfo.getOperator();
        if (operator2 != null ? !operator2.equals(operator3) : operator3 != null) {
            return false;
        }
        if (getOrderOrigTime() != algoOrderInfo.getOrderOrigTime() || getLastActTime() != algoOrderInfo.getLastActTime()) {
            return false;
        }
        String orderStatus2 = getOrderStatus();
        String orderStatus3 = algoOrderInfo.getOrderStatus();
        if (orderStatus2 != null ? !orderStatus2.equals(orderStatus3) : orderStatus3 != null) {
            return false;
        }
        if (getOrderCreateTime() != algoOrderInfo.getOrderCreateTime() || getDelegateType() != algoOrderInfo.getDelegateType() || getOrderPriceType() != algoOrderInfo.getOrderPriceType()) {
            return false;
        }
        String orderPriceRatio2 = getOrderPriceRatio();
        String orderPriceRatio3 = algoOrderInfo.getOrderPriceRatio();
        if (orderPriceRatio2 != null ? !orderPriceRatio2.equals(orderPriceRatio3) : orderPriceRatio3 != null) {
            return false;
        }
        String orderPriceGap2 = getOrderPriceGap();
        String orderPriceGap3 = algoOrderInfo.getOrderPriceGap();
        if (orderPriceGap2 != null ? !orderPriceGap2.equals(orderPriceGap3) : orderPriceGap3 != null) {
            return false;
        }
        if (getSingleOrderType() != algoOrderInfo.getSingleOrderType()) {
            return false;
        }
        String singleOrderSize2 = getSingleOrderSize();
        String singleOrderSize3 = algoOrderInfo.getSingleOrderSize();
        if (singleOrderSize2 != null ? !singleOrderSize2.equals(singleOrderSize3) : singleOrderSize3 != null) {
            return false;
        }
        String singleOrderRatio2 = getSingleOrderRatio();
        String singleOrderRatio3 = algoOrderInfo.getSingleOrderRatio();
        if (singleOrderRatio2 != null ? !singleOrderRatio2.equals(singleOrderRatio3) : singleOrderRatio3 != null) {
            return false;
        }
        String interval2 = getInterval();
        String interval3 = algoOrderInfo.getInterval();
        if (interval2 != null ? !interval2.equals(interval3) : interval3 != null) {
            return false;
        }
        String orderFinishSize2 = getOrderFinishSize();
        String orderFinishSize3 = algoOrderInfo.getOrderFinishSize();
        if (orderFinishSize2 != null ? !orderFinishSize2.equals(orderFinishSize3) : orderFinishSize3 != null) {
            return false;
        }
        String errCode2 = getErrCode();
        String errCode3 = algoOrderInfo.getErrCode();
        if (errCode2 != null ? !errCode2.equals(errCode3) : errCode3 != null) {
            return false;
        }
        String errMessage2 = getErrMessage();
        String errMessage3 = algoOrderInfo.getErrMessage();
        if (errMessage2 != null ? !errMessage2.equals(errMessage3) : errMessage3 != null) {
            return false;
        }
        String iceAmount2 = getIceAmount();
        String iceAmount3 = algoOrderInfo.getIceAmount();
        return iceAmount2 != null ? iceAmount2.equals(iceAmount3) : iceAmount3 == null;
    }

    public long getAccountId() {
        return this.accountId;
    }

    public String getClientOrderId() {
        return this.clientOrderId;
    }

    public int getDelegateType() {
        return this.delegateType;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMessage() {
        return this.errMessage;
    }

    public String getIceAmount() {
        return this.iceAmount;
    }

    public long getId() {
        return this.f70607id;
    }

    public String getInterval() {
        return this.interval;
    }

    public long getLastActTime() {
        return this.lastActTime;
    }

    public String getOperator() {
        return this.operator;
    }

    public long getOrderCreateTime() {
        return this.orderCreateTime;
    }

    public String getOrderFinishSize() {
        return this.orderFinishSize;
    }

    public long getOrderOrigTime() {
        return this.orderOrigTime;
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

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public String getOrderValue() {
        return this.orderValue;
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

    public String getStopPrice() {
        return this.stopPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTimeInForce() {
        return this.timeInForce;
    }

    public int hashCode() {
        long id2 = getId();
        long accountId2 = getAccountId();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (accountId2 ^ (accountId2 >>> 32)));
        String source2 = getSource();
        int i12 = 43;
        int hashCode = (i11 * 59) + (source2 == null ? 43 : source2.hashCode());
        String clientOrderId2 = getClientOrderId();
        int hashCode2 = (hashCode * 59) + (clientOrderId2 == null ? 43 : clientOrderId2.hashCode());
        String symbol2 = getSymbol();
        int hashCode3 = (hashCode2 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode4 = (hashCode3 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        String orderSize2 = getOrderSize();
        int hashCode5 = (hashCode4 * 59) + (orderSize2 == null ? 43 : orderSize2.hashCode());
        String orderValue2 = getOrderValue();
        int hashCode6 = (hashCode5 * 59) + (orderValue2 == null ? 43 : orderValue2.hashCode());
        String orderSide2 = getOrderSide();
        int hashCode7 = (hashCode6 * 59) + (orderSide2 == null ? 43 : orderSide2.hashCode());
        String timeInForce2 = getTimeInForce();
        int hashCode8 = (hashCode7 * 59) + (timeInForce2 == null ? 43 : timeInForce2.hashCode());
        String orderType2 = getOrderType();
        int hashCode9 = (hashCode8 * 59) + (orderType2 == null ? 43 : orderType2.hashCode());
        String stopPrice2 = getStopPrice();
        int hashCode10 = (hashCode9 * 59) + (stopPrice2 == null ? 43 : stopPrice2.hashCode());
        String operator2 = getOperator();
        int i13 = hashCode10 * 59;
        int hashCode11 = operator2 == null ? 43 : operator2.hashCode();
        long orderOrigTime2 = getOrderOrigTime();
        long lastActTime2 = getLastActTime();
        int i14 = ((((i13 + hashCode11) * 59) + ((int) (orderOrigTime2 ^ (orderOrigTime2 >>> 32)))) * 59) + ((int) (lastActTime2 ^ (lastActTime2 >>> 32)));
        String orderStatus2 = getOrderStatus();
        int i15 = i14 * 59;
        int hashCode12 = orderStatus2 == null ? 43 : orderStatus2.hashCode();
        long orderCreateTime2 = getOrderCreateTime();
        int delegateType2 = ((((((i15 + hashCode12) * 59) + ((int) ((orderCreateTime2 >>> 32) ^ orderCreateTime2))) * 59) + getDelegateType()) * 59) + getOrderPriceType();
        String orderPriceRatio2 = getOrderPriceRatio();
        int hashCode13 = (delegateType2 * 59) + (orderPriceRatio2 == null ? 43 : orderPriceRatio2.hashCode());
        String orderPriceGap2 = getOrderPriceGap();
        int hashCode14 = (((hashCode13 * 59) + (orderPriceGap2 == null ? 43 : orderPriceGap2.hashCode())) * 59) + getSingleOrderType();
        String singleOrderSize2 = getSingleOrderSize();
        int hashCode15 = (hashCode14 * 59) + (singleOrderSize2 == null ? 43 : singleOrderSize2.hashCode());
        String singleOrderRatio2 = getSingleOrderRatio();
        int hashCode16 = (hashCode15 * 59) + (singleOrderRatio2 == null ? 43 : singleOrderRatio2.hashCode());
        String interval2 = getInterval();
        int hashCode17 = (hashCode16 * 59) + (interval2 == null ? 43 : interval2.hashCode());
        String orderFinishSize2 = getOrderFinishSize();
        int hashCode18 = (hashCode17 * 59) + (orderFinishSize2 == null ? 43 : orderFinishSize2.hashCode());
        String errCode2 = getErrCode();
        int hashCode19 = (hashCode18 * 59) + (errCode2 == null ? 43 : errCode2.hashCode());
        String errMessage2 = getErrMessage();
        int hashCode20 = (hashCode19 * 59) + (errMessage2 == null ? 43 : errMessage2.hashCode());
        String iceAmount2 = getIceAmount();
        int i16 = hashCode20 * 59;
        if (iceAmount2 != null) {
            i12 = iceAmount2.hashCode();
        }
        return i16 + i12;
    }

    public boolean isLimitOrderType() {
        return "limit".equals(this.orderType);
    }

    public void setAccountId(long j11) {
        this.accountId = j11;
    }

    public void setClientOrderId(String str) {
        this.clientOrderId = str;
    }

    public void setDelegateType(int i11) {
        this.delegateType = i11;
    }

    public void setErrCode(String str) {
        this.errCode = str;
    }

    public void setErrMessage(String str) {
        this.errMessage = str;
    }

    public void setIceAmount(String str) {
        this.iceAmount = str;
    }

    public void setId(long j11) {
        this.f70607id = j11;
    }

    public void setInterval(String str) {
        this.interval = str;
    }

    public void setLastActTime(long j11) {
        this.lastActTime = j11;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setOrderCreateTime(long j11) {
        this.orderCreateTime = j11;
    }

    public void setOrderFinishSize(String str) {
        this.orderFinishSize = str;
    }

    public void setOrderOrigTime(long j11) {
        this.orderOrigTime = j11;
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

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public void setOrderValue(String str) {
        this.orderValue = str;
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

    public void setStopPrice(String str) {
        this.stopPrice = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTimeInForce(String str) {
        this.timeInForce = str;
    }

    public String toString() {
        return "AlgoOrderInfo(id=" + getId() + ", accountId=" + getAccountId() + ", source=" + getSource() + ", clientOrderId=" + getClientOrderId() + ", symbol=" + getSymbol() + ", orderPrice=" + getOrderPrice() + ", orderSize=" + getOrderSize() + ", orderValue=" + getOrderValue() + ", orderSide=" + getOrderSide() + ", timeInForce=" + getTimeInForce() + ", orderType=" + getOrderType() + ", stopPrice=" + getStopPrice() + ", operator=" + getOperator() + ", orderOrigTime=" + getOrderOrigTime() + ", lastActTime=" + getLastActTime() + ", orderStatus=" + getOrderStatus() + ", orderCreateTime=" + getOrderCreateTime() + ", delegateType=" + getDelegateType() + ", orderPriceType=" + getOrderPriceType() + ", orderPriceRatio=" + getOrderPriceRatio() + ", orderPriceGap=" + getOrderPriceGap() + ", singleOrderType=" + getSingleOrderType() + ", singleOrderSize=" + getSingleOrderSize() + ", singleOrderRatio=" + getSingleOrderRatio() + ", interval=" + getInterval() + ", orderFinishSize=" + getOrderFinishSize() + ", errCode=" + getErrCode() + ", errMessage=" + getErrMessage() + ", iceAmount=" + getIceAmount() + ")";
    }
}
