package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;
import java.util.List;

public class AlgoSpecificOrderInfo implements Serializable {
    private long accountId;
    private String clientOrderId;
    private int delegateType;
    private String errCode;
    private String errMessage;

    /* renamed from: id  reason: collision with root package name */
    private long f70609id;
    private String interval;
    private long lastActTime;
    private String operator;
    private long orderCreateTime;
    private Long orderExecuteTime;
    private String orderFinishSize;
    private long orderId;
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
    private List<PeriodTrade> periodTrades;
    private String singleOrderRatio;
    private String singleOrderSize;
    private int singleOrderType;
    private String source;
    private String stopPrice;
    private String symbol;
    private String timeInForce;

    public boolean canEqual(Object obj) {
        return obj instanceof AlgoSpecificOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlgoSpecificOrderInfo)) {
            return false;
        }
        AlgoSpecificOrderInfo algoSpecificOrderInfo = (AlgoSpecificOrderInfo) obj;
        if (!algoSpecificOrderInfo.canEqual(this) || getId() != algoSpecificOrderInfo.getId() || getAccountId() != algoSpecificOrderInfo.getAccountId()) {
            return false;
        }
        String source2 = getSource();
        String source3 = algoSpecificOrderInfo.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        if (getOrderId() != algoSpecificOrderInfo.getOrderId()) {
            return false;
        }
        String clientOrderId2 = getClientOrderId();
        String clientOrderId3 = algoSpecificOrderInfo.getClientOrderId();
        if (clientOrderId2 != null ? !clientOrderId2.equals(clientOrderId3) : clientOrderId3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = algoSpecificOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = algoSpecificOrderInfo.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        String orderSize2 = getOrderSize();
        String orderSize3 = algoSpecificOrderInfo.getOrderSize();
        if (orderSize2 != null ? !orderSize2.equals(orderSize3) : orderSize3 != null) {
            return false;
        }
        String orderValue2 = getOrderValue();
        String orderValue3 = algoSpecificOrderInfo.getOrderValue();
        if (orderValue2 != null ? !orderValue2.equals(orderValue3) : orderValue3 != null) {
            return false;
        }
        String orderSide2 = getOrderSide();
        String orderSide3 = algoSpecificOrderInfo.getOrderSide();
        if (orderSide2 != null ? !orderSide2.equals(orderSide3) : orderSide3 != null) {
            return false;
        }
        String timeInForce2 = getTimeInForce();
        String timeInForce3 = algoSpecificOrderInfo.getTimeInForce();
        if (timeInForce2 != null ? !timeInForce2.equals(timeInForce3) : timeInForce3 != null) {
            return false;
        }
        String orderType2 = getOrderType();
        String orderType3 = algoSpecificOrderInfo.getOrderType();
        if (orderType2 != null ? !orderType2.equals(orderType3) : orderType3 != null) {
            return false;
        }
        String stopPrice2 = getStopPrice();
        String stopPrice3 = algoSpecificOrderInfo.getStopPrice();
        if (stopPrice2 != null ? !stopPrice2.equals(stopPrice3) : stopPrice3 != null) {
            return false;
        }
        String operator2 = getOperator();
        String operator3 = algoSpecificOrderInfo.getOperator();
        if (operator2 != null ? !operator2.equals(operator3) : operator3 != null) {
            return false;
        }
        if (getOrderOrigTime() != algoSpecificOrderInfo.getOrderOrigTime() || getLastActTime() != algoSpecificOrderInfo.getLastActTime()) {
            return false;
        }
        String orderStatus2 = getOrderStatus();
        String orderStatus3 = algoSpecificOrderInfo.getOrderStatus();
        if (orderStatus2 != null ? !orderStatus2.equals(orderStatus3) : orderStatus3 != null) {
            return false;
        }
        if (getOrderCreateTime() != algoSpecificOrderInfo.getOrderCreateTime() || getDelegateType() != algoSpecificOrderInfo.getDelegateType() || getOrderPriceType() != algoSpecificOrderInfo.getOrderPriceType()) {
            return false;
        }
        String orderPriceRatio2 = getOrderPriceRatio();
        String orderPriceRatio3 = algoSpecificOrderInfo.getOrderPriceRatio();
        if (orderPriceRatio2 != null ? !orderPriceRatio2.equals(orderPriceRatio3) : orderPriceRatio3 != null) {
            return false;
        }
        String orderPriceGap2 = getOrderPriceGap();
        String orderPriceGap3 = algoSpecificOrderInfo.getOrderPriceGap();
        if (orderPriceGap2 != null ? !orderPriceGap2.equals(orderPriceGap3) : orderPriceGap3 != null) {
            return false;
        }
        if (getSingleOrderType() != algoSpecificOrderInfo.getSingleOrderType()) {
            return false;
        }
        String singleOrderSize2 = getSingleOrderSize();
        String singleOrderSize3 = algoSpecificOrderInfo.getSingleOrderSize();
        if (singleOrderSize2 != null ? !singleOrderSize2.equals(singleOrderSize3) : singleOrderSize3 != null) {
            return false;
        }
        String singleOrderRatio2 = getSingleOrderRatio();
        String singleOrderRatio3 = algoSpecificOrderInfo.getSingleOrderRatio();
        if (singleOrderRatio2 != null ? !singleOrderRatio2.equals(singleOrderRatio3) : singleOrderRatio3 != null) {
            return false;
        }
        String interval2 = getInterval();
        String interval3 = algoSpecificOrderInfo.getInterval();
        if (interval2 != null ? !interval2.equals(interval3) : interval3 != null) {
            return false;
        }
        String orderFinishSize2 = getOrderFinishSize();
        String orderFinishSize3 = algoSpecificOrderInfo.getOrderFinishSize();
        if (orderFinishSize2 != null ? !orderFinishSize2.equals(orderFinishSize3) : orderFinishSize3 != null) {
            return false;
        }
        Long orderExecuteTime2 = getOrderExecuteTime();
        Long orderExecuteTime3 = algoSpecificOrderInfo.getOrderExecuteTime();
        if (orderExecuteTime2 != null ? !orderExecuteTime2.equals(orderExecuteTime3) : orderExecuteTime3 != null) {
            return false;
        }
        String errCode2 = getErrCode();
        String errCode3 = algoSpecificOrderInfo.getErrCode();
        if (errCode2 != null ? !errCode2.equals(errCode3) : errCode3 != null) {
            return false;
        }
        String errMessage2 = getErrMessage();
        String errMessage3 = algoSpecificOrderInfo.getErrMessage();
        if (errMessage2 != null ? !errMessage2.equals(errMessage3) : errMessage3 != null) {
            return false;
        }
        List<PeriodTrade> periodTrades2 = getPeriodTrades();
        List<PeriodTrade> periodTrades3 = algoSpecificOrderInfo.getPeriodTrades();
        return periodTrades2 != null ? periodTrades2.equals(periodTrades3) : periodTrades3 == null;
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

    public long getId() {
        return this.f70609id;
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

    public Long getOrderExecuteTime() {
        return this.orderExecuteTime;
    }

    public String getOrderFinishSize() {
        return this.orderFinishSize;
    }

    public long getOrderId() {
        return this.orderId;
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

    public List<PeriodTrade> getPeriodTrades() {
        return this.periodTrades;
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
        int i12 = i11 * 59;
        int i13 = 43;
        int hashCode = source2 == null ? 43 : source2.hashCode();
        long orderId2 = getOrderId();
        int i14 = ((i12 + hashCode) * 59) + ((int) (orderId2 ^ (orderId2 >>> 32)));
        String clientOrderId2 = getClientOrderId();
        int hashCode2 = (i14 * 59) + (clientOrderId2 == null ? 43 : clientOrderId2.hashCode());
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
        int i15 = hashCode10 * 59;
        int hashCode11 = operator2 == null ? 43 : operator2.hashCode();
        long orderOrigTime2 = getOrderOrigTime();
        long lastActTime2 = getLastActTime();
        int i16 = ((((i15 + hashCode11) * 59) + ((int) (orderOrigTime2 ^ (orderOrigTime2 >>> 32)))) * 59) + ((int) (lastActTime2 ^ (lastActTime2 >>> 32)));
        String orderStatus2 = getOrderStatus();
        int i17 = i16 * 59;
        int hashCode12 = orderStatus2 == null ? 43 : orderStatus2.hashCode();
        long orderCreateTime2 = getOrderCreateTime();
        int delegateType2 = ((((((i17 + hashCode12) * 59) + ((int) ((orderCreateTime2 >>> 32) ^ orderCreateTime2))) * 59) + getDelegateType()) * 59) + getOrderPriceType();
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
        Long orderExecuteTime2 = getOrderExecuteTime();
        int hashCode19 = (hashCode18 * 59) + (orderExecuteTime2 == null ? 43 : orderExecuteTime2.hashCode());
        String errCode2 = getErrCode();
        int hashCode20 = (hashCode19 * 59) + (errCode2 == null ? 43 : errCode2.hashCode());
        String errMessage2 = getErrMessage();
        int hashCode21 = (hashCode20 * 59) + (errMessage2 == null ? 43 : errMessage2.hashCode());
        List<PeriodTrade> periodTrades2 = getPeriodTrades();
        int i18 = hashCode21 * 59;
        if (periodTrades2 != null) {
            i13 = periodTrades2.hashCode();
        }
        return i18 + i13;
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

    public void setId(long j11) {
        this.f70609id = j11;
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

    public void setOrderExecuteTime(Long l11) {
        this.orderExecuteTime = l11;
    }

    public void setOrderFinishSize(String str) {
        this.orderFinishSize = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
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

    public void setPeriodTrades(List<PeriodTrade> list) {
        this.periodTrades = list;
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
        return "AlgoSpecificOrderInfo(id=" + getId() + ", accountId=" + getAccountId() + ", source=" + getSource() + ", orderId=" + getOrderId() + ", clientOrderId=" + getClientOrderId() + ", symbol=" + getSymbol() + ", orderPrice=" + getOrderPrice() + ", orderSize=" + getOrderSize() + ", orderValue=" + getOrderValue() + ", orderSide=" + getOrderSide() + ", timeInForce=" + getTimeInForce() + ", orderType=" + getOrderType() + ", stopPrice=" + getStopPrice() + ", operator=" + getOperator() + ", orderOrigTime=" + getOrderOrigTime() + ", lastActTime=" + getLastActTime() + ", orderStatus=" + getOrderStatus() + ", orderCreateTime=" + getOrderCreateTime() + ", delegateType=" + getDelegateType() + ", orderPriceType=" + getOrderPriceType() + ", orderPriceRatio=" + getOrderPriceRatio() + ", orderPriceGap=" + getOrderPriceGap() + ", singleOrderType=" + getSingleOrderType() + ", singleOrderSize=" + getSingleOrderSize() + ", singleOrderRatio=" + getSingleOrderRatio() + ", interval=" + getInterval() + ", orderFinishSize=" + getOrderFinishSize() + ", orderExecuteTime=" + getOrderExecuteTime() + ", errCode=" + getErrCode() + ", errMessage=" + getErrMessage() + ", periodTrades=" + getPeriodTrades() + ")";
    }
}
