package com.hbg.module.market.widget.bean;

import com.hbg.module.market.widget.viewhandler.MarketSearchResultHeaderHandler;
import java.io.Serializable;
import s9.a;

public class MarketSearchResultHeaderItem implements a, Serializable {
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getViewHandlerName() {
        return MarketSearchResultHeaderHandler.class.getName();
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
