package com.hbg.module.market.widget.bean;

import com.hbg.module.market.widget.viewhandler.MarketSymbolHeaderHandler;
import java.io.Serializable;
import s9.a;

public class MarketSymbolHeaderItem implements a, Serializable {
    public String getViewHandlerName() {
        return MarketSymbolHeaderHandler.class.getName();
    }
}
