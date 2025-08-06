package com.huobi.contract.entity;

import com.huobi.contract.viewhandler.PositionEmptyItemHandler;
import s9.a;

public class PositionEmptyItem implements a {
    public String getViewHandlerName() {
        return PositionEmptyItemHandler.class.getName();
    }
}
