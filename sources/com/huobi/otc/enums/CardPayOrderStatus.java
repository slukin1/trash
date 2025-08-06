package com.huobi.otc.enums;

public enum CardPayOrderStatus {
    TRADE_SUCCESS(3),
    TRADE_PAY_FAIL(104),
    TRADE_PAYING(103),
    TRADE_ERROR(105);
    
    public int value;

    private CardPayOrderStatus(int i11) {
        this.value = i11;
    }

    public int getValue() {
        return this.value;
    }
}
