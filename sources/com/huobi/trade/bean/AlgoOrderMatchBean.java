package com.huobi.trade.bean;

import com.hbg.lib.network.pro.core.bean.PeriodTrade;
import java.io.Serializable;

public class AlgoOrderMatchBean implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private long f81919id;
    private String orderSide;
    public PeriodTrade periodTrade;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof AlgoOrderMatchBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlgoOrderMatchBean)) {
            return false;
        }
        AlgoOrderMatchBean algoOrderMatchBean = (AlgoOrderMatchBean) obj;
        if (!algoOrderMatchBean.canEqual(this) || getId() != algoOrderMatchBean.getId()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = algoOrderMatchBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String orderSide2 = getOrderSide();
        String orderSide3 = algoOrderMatchBean.getOrderSide();
        if (orderSide2 != null ? !orderSide2.equals(orderSide3) : orderSide3 != null) {
            return false;
        }
        PeriodTrade periodTrade2 = getPeriodTrade();
        PeriodTrade periodTrade3 = algoOrderMatchBean.getPeriodTrade();
        return periodTrade2 != null ? periodTrade2.equals(periodTrade3) : periodTrade3 == null;
    }

    public long getId() {
        return this.f81919id;
    }

    public String getOrderSide() {
        return this.orderSide;
    }

    public PeriodTrade getPeriodTrade() {
        return this.periodTrade;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        long id2 = getId();
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String orderSide2 = getOrderSide();
        int hashCode2 = (hashCode * 59) + (orderSide2 == null ? 43 : orderSide2.hashCode());
        PeriodTrade periodTrade2 = getPeriodTrade();
        int i12 = hashCode2 * 59;
        if (periodTrade2 != null) {
            i11 = periodTrade2.hashCode();
        }
        return i12 + i11;
    }

    public void setId(long j11) {
        this.f81919id = j11;
    }

    public void setOrderSide(String str) {
        this.orderSide = str;
    }

    public void setPeriodTrade(PeriodTrade periodTrade2) {
        this.periodTrade = periodTrade2;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "AlgoOrderMatchBean(id=" + getId() + ", symbol=" + getSymbol() + ", orderSide=" + getOrderSide() + ", periodTrade=" + getPeriodTrade() + ")";
    }
}
