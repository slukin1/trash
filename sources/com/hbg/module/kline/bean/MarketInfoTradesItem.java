package com.hbg.module.kline.bean;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.MarketTradeDetailInfo;
import com.hbg.module.kline.handler.MarketInfoTradesHandler;
import java.io.Serializable;
import s9.a;

public class MarketInfoTradesItem implements a, Serializable {
    public static final String TRADES_TYPE_BUY = "buy";
    public static final String TRADES_TYPE_SELL = "sell";
    private static final long serialVersionUID = 3180429936866984687L;
    private MarketTradeDetailInfo tradeDetailInfo;
    private TradeType tradeType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.tradeDetailInfo == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.tradeDetailInfo.getId().equals(((MarketInfoTradesItem) obj).tradeDetailInfo.getId());
    }

    public MarketTradeDetailInfo getTradeDetailInfo() {
        return this.tradeDetailInfo;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public String getViewHandlerName() {
        return MarketInfoTradesHandler.class.getName();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setTradeDetailInfo(MarketTradeDetailInfo marketTradeDetailInfo) {
        this.tradeDetailInfo = marketTradeDetailInfo;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public String toString() {
        return "MarketInfoTradesItem(tradeDetailInfo=" + getTradeDetailInfo() + ", tradeType=" + getTradeType() + ")";
    }
}
