package com.kakao.message.template;

public enum CurrencyUnitPosition {
    REAR(0),
    FRONT(1);
    
    public final Integer value;

    private CurrencyUnitPosition(Integer num) {
        this.value = num;
    }

    public Integer getValue() {
        return this.value;
    }
}
