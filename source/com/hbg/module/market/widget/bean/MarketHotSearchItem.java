package com.hbg.module.market.widget.bean;

import com.hbg.module.market.widget.viewhandler.MarketHotSearchItemHandler;
import java.io.Serializable;
import s9.a;

public class MarketHotSearchItem implements a, Serializable {
    private String symbol;

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return MarketHotSearchItemHandler.class.getName();
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }
}
