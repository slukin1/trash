package com.huobi.otc.enums;

import com.huobi.points.entity.PointsPack;

public enum BindAddCardResult {
    FAIL("fail"),
    PENDING(PointsPack.STATE_PENDING),
    SUCCESS("success"),
    FINISH("finish"),
    OPERATION("operation");
    
    public String value;

    private BindAddCardResult(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
