package com.huobi.trade.bean;

import com.huobi.trade.handler.TradingBotSelectMarketHeadHandler;
import java.io.Serializable;
import s9.a;

public class TradingBotSelectMarketHead implements Serializable, a {
    private String letter;

    public TradingBotSelectMarketHead(String str) {
        this.letter = str;
    }

    public String getLetter() {
        return this.letter;
    }

    public String getViewHandlerName() {
        return TradingBotSelectMarketHeadHandler.class.getName();
    }
}
