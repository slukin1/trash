package com.huobi.finance.bean;

public enum FiatDWEntrance {
    unknown(0),
    normal(1),
    extra(2);
    
    private final int value;

    private FiatDWEntrance(int i11) {
        this.value = i11;
    }

    public int getValue() {
        return this.value;
    }
}
