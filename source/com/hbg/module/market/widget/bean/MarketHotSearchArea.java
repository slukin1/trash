package com.hbg.module.market.widget.bean;

import com.hbg.module.market.widget.viewhandler.MarketHotSearchAreaHandler;
import java.io.Serializable;
import s9.a;

public class MarketHotSearchArea implements a, Serializable {
    public String getViewHandlerName() {
        return MarketHotSearchAreaHandler.class.getName();
    }
}
