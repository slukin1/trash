package com.huobi.search.bean;

import com.huobi.search.viewhandler.HotSearchItemHandler;
import java.io.Serializable;
import s9.a;

public class HotSearchItem implements a, Serializable {
    private static final long serialVersionUID = 130677528478714907L;
    private String symbol;

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return HotSearchItemHandler.class.getName();
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }
}
