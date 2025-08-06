package com.hbg.module.huobi.im.utils;

public enum LiveGiftRule {
    RULE_REALTIME(1),
    RULE_FIXED_TIME(2),
    RULE_TASK(3);
    
    private final int value;

    private LiveGiftRule(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
