package com.huobi.order.bean;

import android.content.Context;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.huobi.trade.handler.CurrentTimeOrderHandler;
import java.io.Serializable;

public class CurrentTimeTradeInfo implements Serializable, s9.a {
    private a callback;
    private boolean isTrade;
    private AlgoOrderInfo orderInfo;
    private TradeType tradeType;

    public interface a {
        void a(CurrentTimeTradeInfo currentTimeTradeInfo, Context context);

        void b(CurrentTimeTradeInfo currentTimeTradeInfo, Context context);

        void c(CurrentTimeTradeInfo currentTimeTradeInfo, Context context);
    }

    public CurrentTimeTradeInfo(AlgoOrderInfo algoOrderInfo) {
        this.orderInfo = algoOrderInfo;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CurrentTimeTradeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrentTimeTradeInfo)) {
            return false;
        }
        CurrentTimeTradeInfo currentTimeTradeInfo = (CurrentTimeTradeInfo) obj;
        if (!currentTimeTradeInfo.canEqual(this)) {
            return false;
        }
        AlgoOrderInfo orderInfo2 = getOrderInfo();
        AlgoOrderInfo orderInfo3 = currentTimeTradeInfo.getOrderInfo();
        if (orderInfo2 != null ? !orderInfo2.equals(orderInfo3) : orderInfo3 != null) {
            return false;
        }
        if (isTrade() != currentTimeTradeInfo.isTrade()) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = currentTimeTradeInfo.getCallback();
        if (callback2 != null ? !callback2.equals(callback3) : callback3 != null) {
            return false;
        }
        TradeType tradeType2 = getTradeType();
        TradeType tradeType3 = currentTimeTradeInfo.getTradeType();
        return tradeType2 != null ? tradeType2.equals(tradeType3) : tradeType3 == null;
    }

    public a getCallback() {
        return this.callback;
    }

    public Long getId() {
        AlgoOrderInfo algoOrderInfo = this.orderInfo;
        if (algoOrderInfo == null) {
            return 0L;
        }
        return Long.valueOf(algoOrderInfo.getId());
    }

    public AlgoOrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    public String getSymbol() {
        return this.orderInfo.getSymbol();
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public String getViewHandlerName() {
        return CurrentTimeOrderHandler.class.getName();
    }

    public int hashCode() {
        AlgoOrderInfo orderInfo2 = getOrderInfo();
        int i11 = 43;
        int hashCode = (((orderInfo2 == null ? 43 : orderInfo2.hashCode()) + 59) * 59) + (isTrade() ? 79 : 97);
        a callback2 = getCallback();
        int hashCode2 = (hashCode * 59) + (callback2 == null ? 43 : callback2.hashCode());
        TradeType tradeType2 = getTradeType();
        int i12 = hashCode2 * 59;
        if (tradeType2 != null) {
            i11 = tradeType2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isTrade() {
        return this.isTrade;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setOrderInfo(AlgoOrderInfo algoOrderInfo) {
        this.orderInfo = algoOrderInfo;
    }

    public void setTrade(boolean z11) {
        this.isTrade = z11;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public String toString() {
        return "CurrentTimeTradeInfo(orderInfo=" + getOrderInfo() + ", isTrade=" + isTrade() + ", callback=" + getCallback() + ", tradeType=" + getTradeType() + ")";
    }

    public CurrentTimeTradeInfo(AlgoOrderInfo algoOrderInfo, boolean z11) {
        this.orderInfo = algoOrderInfo;
        this.isTrade = z11;
    }
}
