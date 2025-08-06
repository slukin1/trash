package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class PeriodTrade implements Serializable {
    private String orderAmount;
    private String orderFee;
    private String orderHt;
    private String orderLimitPrice;
    private String orderLimitSize;
    private String orderPoint;
    private String orderPrice;
    private String orderSize;
    private Long orderTradeTime;

    public boolean canEqual(Object obj) {
        return obj instanceof PeriodTrade;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PeriodTrade)) {
            return false;
        }
        PeriodTrade periodTrade = (PeriodTrade) obj;
        if (!periodTrade.canEqual(this)) {
            return false;
        }
        Long orderTradeTime2 = getOrderTradeTime();
        Long orderTradeTime3 = periodTrade.getOrderTradeTime();
        if (orderTradeTime2 != null ? !orderTradeTime2.equals(orderTradeTime3) : orderTradeTime3 != null) {
            return false;
        }
        String orderLimitPrice2 = getOrderLimitPrice();
        String orderLimitPrice3 = periodTrade.getOrderLimitPrice();
        if (orderLimitPrice2 != null ? !orderLimitPrice2.equals(orderLimitPrice3) : orderLimitPrice3 != null) {
            return false;
        }
        String orderLimitSize2 = getOrderLimitSize();
        String orderLimitSize3 = periodTrade.getOrderLimitSize();
        if (orderLimitSize2 != null ? !orderLimitSize2.equals(orderLimitSize3) : orderLimitSize3 != null) {
            return false;
        }
        String orderAmount2 = getOrderAmount();
        String orderAmount3 = periodTrade.getOrderAmount();
        if (orderAmount2 != null ? !orderAmount2.equals(orderAmount3) : orderAmount3 != null) {
            return false;
        }
        String orderPrice2 = getOrderPrice();
        String orderPrice3 = periodTrade.getOrderPrice();
        if (orderPrice2 != null ? !orderPrice2.equals(orderPrice3) : orderPrice3 != null) {
            return false;
        }
        String orderSize2 = getOrderSize();
        String orderSize3 = periodTrade.getOrderSize();
        if (orderSize2 != null ? !orderSize2.equals(orderSize3) : orderSize3 != null) {
            return false;
        }
        String orderFee2 = getOrderFee();
        String orderFee3 = periodTrade.getOrderFee();
        if (orderFee2 != null ? !orderFee2.equals(orderFee3) : orderFee3 != null) {
            return false;
        }
        String orderPoint2 = getOrderPoint();
        String orderPoint3 = periodTrade.getOrderPoint();
        if (orderPoint2 != null ? !orderPoint2.equals(orderPoint3) : orderPoint3 != null) {
            return false;
        }
        String orderHt2 = getOrderHt();
        String orderHt3 = periodTrade.getOrderHt();
        return orderHt2 != null ? orderHt2.equals(orderHt3) : orderHt3 == null;
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

    public String getOrderSize() {
        return this.orderSize;
    }

    public Long getOrderTradeTime() {
        return this.orderTradeTime;
    }

    public int hashCode() {
        Long orderTradeTime2 = getOrderTradeTime();
        int i11 = 43;
        int hashCode = orderTradeTime2 == null ? 43 : orderTradeTime2.hashCode();
        String orderLimitPrice2 = getOrderLimitPrice();
        int hashCode2 = ((hashCode + 59) * 59) + (orderLimitPrice2 == null ? 43 : orderLimitPrice2.hashCode());
        String orderLimitSize2 = getOrderLimitSize();
        int hashCode3 = (hashCode2 * 59) + (orderLimitSize2 == null ? 43 : orderLimitSize2.hashCode());
        String orderAmount2 = getOrderAmount();
        int hashCode4 = (hashCode3 * 59) + (orderAmount2 == null ? 43 : orderAmount2.hashCode());
        String orderPrice2 = getOrderPrice();
        int hashCode5 = (hashCode4 * 59) + (orderPrice2 == null ? 43 : orderPrice2.hashCode());
        String orderSize2 = getOrderSize();
        int hashCode6 = (hashCode5 * 59) + (orderSize2 == null ? 43 : orderSize2.hashCode());
        String orderFee2 = getOrderFee();
        int hashCode7 = (hashCode6 * 59) + (orderFee2 == null ? 43 : orderFee2.hashCode());
        String orderPoint2 = getOrderPoint();
        int hashCode8 = (hashCode7 * 59) + (orderPoint2 == null ? 43 : orderPoint2.hashCode());
        String orderHt2 = getOrderHt();
        int i12 = hashCode8 * 59;
        if (orderHt2 != null) {
            i11 = orderHt2.hashCode();
        }
        return i12 + i11;
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

    public void setOrderSize(String str) {
        this.orderSize = str;
    }

    public void setOrderTradeTime(Long l11) {
        this.orderTradeTime = l11;
    }

    public String toString() {
        return "PeriodTrade(orderTradeTime=" + getOrderTradeTime() + ", orderLimitPrice=" + getOrderLimitPrice() + ", orderLimitSize=" + getOrderLimitSize() + ", orderAmount=" + getOrderAmount() + ", orderPrice=" + getOrderPrice() + ", orderSize=" + getOrderSize() + ", orderFee=" + getOrderFee() + ", orderPoint=" + getOrderPoint() + ", orderHt=" + getOrderHt() + ")";
    }
}
