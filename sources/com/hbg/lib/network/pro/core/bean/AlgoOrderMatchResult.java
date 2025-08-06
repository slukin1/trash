package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class AlgoOrderMatchResult implements Serializable {
    private String clientOrderId;

    /* renamed from: id  reason: collision with root package name */
    private long f70608id;
    private String orderAmount;
    private String orderFee;
    private String orderHt;
    private long orderId;
    private String orderLimitPrice;
    private String orderLimitSize;
    private String orderPoint;
    private String orderPrice;
    private String orderSide;
    private String orderSize;
    private Long orderTradeTime;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof AlgoOrderMatchResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlgoOrderMatchResult)) {
            return false;
        }
        AlgoOrderMatchResult algoOrderMatchResult = (AlgoOrderMatchResult) obj;
        if (!algoOrderMatchResult.canEqual(this) || getId() != algoOrderMatchResult.getId() || getOrderId() != algoOrderMatchResult.getOrderId()) {
            return false;
        }
        String clientOrderId2 = getClientOrderId();
        String clientOrderId3 = algoOrderMatchResult.getClientOrderId();
        if (clientOrderId2 != null ? !clientOrderId2.equals(clientOrderId3) : clientOrderId3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = algoOrderMatchResult.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String orderSide2 = getOrderSide();
        String orderSide3 = algoOrderMatchResult.getOrderSide();
        if (orderSide2 != null ? !orderSide2.equals(orderSide3) : orderSide3 != null) {
            return false;
        }
        Long orderTradeTime2 = getOrderTradeTime();
        Long orderTradeTime3 = algoOrderMatchResult.getOrderTradeTime();
        if (orderTradeTime2 != null ? !orderTradeTime2.equals(orderTradeTime3) : orderTradeTime3 != null) {
            return false;
        }
        String orderLimitPrice2 = getOrderLimitPrice();
        String orderLimitPrice3 = algoOrderMatchResult.getOrderLimitPrice();
        if (orderLimitPrice2 != null ? !orderLimitPrice2.equals(orderLimitPrice3) : orderLimitPrice3 != null) {
            return false;
        }
        String orderLimitSize2 = getOrderLimitSize();
        String orderLimitSize3 = algoOrderMatchResult.getOrderLimitSize();
        if (orderLimitSize2 != null ? !orderLimitSize2.equals(orderLimitSize3) : orderLimitSize3 != null) {
            return false;
        }
        String orderAmount2 = getOrderAmount();
        String orderAmount3 = algoOrderMatchResult.getOrderAmount();
        if (orderAmount2 != null ? !orderAmount2.equals(orderAmount3) : orderAmount3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = algoOrderMatchResult.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        String orderSize2 = getOrderSize();
        String orderSize3 = algoOrderMatchResult.getOrderSize();
        if (orderSize2 != null ? !orderSize2.equals(orderSize3) : orderSize3 != null) {
            return false;
        }
        String orderFee2 = getOrderFee();
        String orderFee3 = algoOrderMatchResult.getOrderFee();
        if (orderFee2 != null ? !orderFee2.equals(orderFee3) : orderFee3 != null) {
            return false;
        }
        String orderPoint2 = getOrderPoint();
        String orderPoint3 = algoOrderMatchResult.getOrderPoint();
        if (orderPoint2 != null ? !orderPoint2.equals(orderPoint3) : orderPoint3 != null) {
            return false;
        }
        String orderHt2 = getOrderHt();
        String orderHt3 = algoOrderMatchResult.getOrderHt();
        return orderHt2 != null ? orderHt2.equals(orderHt3) : orderHt3 == null;
    }

    public String getClientOrderId() {
        return this.clientOrderId;
    }

    public long getId() {
        return this.f70608id;
    }

    public String getOrderAmount() {
        return this.orderAmount;
    }

    public String getOrderFee() {
        return this.orderFee;
    }

    public String getOrderHt() {
        return this.orderHt;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public String getOrderLimitPrice() {
        return this.orderLimitPrice;
    }

    public String getOrderLimitSize() {
        return this.orderLimitSize;
    }

    public String getOrderPoint() {
        return this.orderPoint;
    }

    public String getOrderPrice() {
        return this.orderPrice;
    }

    public String getOrderSide() {
        return this.orderSide;
    }

    public String getOrderSize() {
        return this.orderSize;
    }

    public Long getOrderTradeTime() {
        return this.orderTradeTime;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        long id2 = getId();
        long orderId2 = getOrderId();
        String clientOrderId2 = getClientOrderId();
        int i11 = (((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) ((orderId2 >>> 32) ^ orderId2))) * 59;
        int i12 = 43;
        int hashCode = i11 + (clientOrderId2 == null ? 43 : clientOrderId2.hashCode());
        String symbol2 = getSymbol();
        int hashCode2 = (hashCode * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String orderSide2 = getOrderSide();
        int hashCode3 = (hashCode2 * 59) + (orderSide2 == null ? 43 : orderSide2.hashCode());
        Long orderTradeTime2 = getOrderTradeTime();
        int hashCode4 = (hashCode3 * 59) + (orderTradeTime2 == null ? 43 : orderTradeTime2.hashCode());
        String orderLimitPrice2 = getOrderLimitPrice();
        int hashCode5 = (hashCode4 * 59) + (orderLimitPrice2 == null ? 43 : orderLimitPrice2.hashCode());
        String orderLimitSize2 = getOrderLimitSize();
        int hashCode6 = (hashCode5 * 59) + (orderLimitSize2 == null ? 43 : orderLimitSize2.hashCode());
        String orderAmount2 = getOrderAmount();
        int hashCode7 = (hashCode6 * 59) + (orderAmount2 == null ? 43 : orderAmount2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode8 = (hashCode7 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        String orderSize2 = getOrderSize();
        int hashCode9 = (hashCode8 * 59) + (orderSize2 == null ? 43 : orderSize2.hashCode());
        String orderFee2 = getOrderFee();
        int hashCode10 = (hashCode9 * 59) + (orderFee2 == null ? 43 : orderFee2.hashCode());
        String orderPoint2 = getOrderPoint();
        int hashCode11 = (hashCode10 * 59) + (orderPoint2 == null ? 43 : orderPoint2.hashCode());
        String orderHt2 = getOrderHt();
        int i13 = hashCode11 * 59;
        if (orderHt2 != null) {
            i12 = orderHt2.hashCode();
        }
        return i13 + i12;
    }

    public void setClientOrderId(String str) {
        this.clientOrderId = str;
    }

    public void setId(long j11) {
        this.f70608id = j11;
    }

    public void setOrderAmount(String str) {
        this.orderAmount = str;
    }

    public void setOrderFee(String str) {
        this.orderFee = str;
    }

    public void setOrderHt(String str) {
        this.orderHt = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setOrderLimitPrice(String str) {
        this.orderLimitPrice = str;
    }

    public void setOrderLimitSize(String str) {
        this.orderLimitSize = str;
    }

    public void setOrderPoint(String str) {
        this.orderPoint = str;
    }

    public void setOrderPrice(String str) {
        this.orderPrice = str;
    }

    public void setOrderSide(String str) {
        this.orderSide = str;
    }

    public void setOrderSize(String str) {
        this.orderSize = str;
    }

    public void setOrderTradeTime(Long l11) {
        this.orderTradeTime = l11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "AlgoOrderMatchResult(id=" + getId() + ", orderId=" + getOrderId() + ", clientOrderId=" + getClientOrderId() + ", symbol=" + getSymbol() + ", orderSide=" + getOrderSide() + ", orderTradeTime=" + getOrderTradeTime() + ", orderLimitPrice=" + getOrderLimitPrice() + ", orderLimitSize=" + getOrderLimitSize() + ", orderAmount=" + getOrderAmount() + ", orderPrice=" + getOrderPrice() + ", orderSize=" + getOrderSize() + ", orderFee=" + getOrderFee() + ", orderPoint=" + getOrderPoint() + ", orderHt=" + getOrderHt() + ")";
    }
}
