package com.huobi.order.bean;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.trade.bean.AlgoOrderMatchBean;
import com.huobi.trade.handler.TimeFilledOrderHandler;
import java.io.Serializable;

public class TimeOrderBeanDetails implements Serializable, s9.a {
    public static final int STYLE_FILLED_ORDER = 1;
    private a callback;
    private boolean isTrade;
    private AlgoOrderMatchBean orderInfo;
    private int style = 0;
    private TradeType tradeType;

    public interface a {
    }

    public TimeOrderBeanDetails(AlgoOrderMatchBean algoOrderMatchBean) {
        this.orderInfo = algoOrderMatchBean;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof TimeOrderBeanDetails;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeOrderBeanDetails)) {
            return false;
        }
        TimeOrderBeanDetails timeOrderBeanDetails = (TimeOrderBeanDetails) obj;
        if (!timeOrderBeanDetails.canEqual(this)) {
            return false;
        }
        AlgoOrderMatchBean orderInfo2 = getOrderInfo();
        AlgoOrderMatchBean orderInfo3 = timeOrderBeanDetails.getOrderInfo();
        if (orderInfo2 != null ? !orderInfo2.equals(orderInfo3) : orderInfo3 != null) {
            return false;
        }
        if (isTrade() != timeOrderBeanDetails.isTrade()) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = timeOrderBeanDetails.getCallback();
        if (callback2 != null ? !callback2.equals(callback3) : callback3 != null) {
            return false;
        }
        TradeType tradeType2 = getTradeType();
        TradeType tradeType3 = timeOrderBeanDetails.getTradeType();
        if (tradeType2 != null ? tradeType2.equals(tradeType3) : tradeType3 == null) {
            return getStyle() == timeOrderBeanDetails.getStyle();
        }
        return false;
    }

    public a getCallback() {
        return this.callback;
    }

    public Long getId() {
        AlgoOrderMatchBean algoOrderMatchBean = this.orderInfo;
        if (algoOrderMatchBean == null) {
            return 0L;
        }
        return Long.valueOf(algoOrderMatchBean.getId());
    }

    public AlgoOrderMatchBean getOrderInfo() {
        return this.orderInfo;
    }

    public int getStyle() {
        return this.style;
    }

    public String getSymbol() {
        return this.orderInfo.getSymbol();
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public String getViewHandlerName() {
        return TimeFilledOrderHandler.class.getName();
    }

    public int hashCode() {
        AlgoOrderMatchBean orderInfo2 = getOrderInfo();
        int i11 = 43;
        int hashCode = (((orderInfo2 == null ? 43 : orderInfo2.hashCode()) + 59) * 59) + (isTrade() ? 79 : 97);
        a callback2 = getCallback();
        int hashCode2 = (hashCode * 59) + (callback2 == null ? 43 : callback2.hashCode());
        TradeType tradeType2 = getTradeType();
        int i12 = hashCode2 * 59;
        if (tradeType2 != null) {
            i11 = tradeType2.hashCode();
        }
        return ((i12 + i11) * 59) + getStyle();
    }

    public boolean isTrade() {
        return this.isTrade;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setOrderInfo(AlgoOrderMatchBean algoOrderMatchBean) {
        this.orderInfo = algoOrderMatchBean;
    }

    public void setStyle(int i11) {
        this.style = i11;
    }

    public void setTrade(boolean z11) {
        this.isTrade = z11;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public String toString() {
        return "TimeOrderBeanDetails(orderInfo=" + getOrderInfo() + ", isTrade=" + isTrade() + ", callback=" + getCallback() + ", tradeType=" + getTradeType() + ", style=" + getStyle() + ")";
    }
}
