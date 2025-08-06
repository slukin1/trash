package com.huobi.otc.enums;

public enum QuoteInfoTagEnum {
    NORMAL(0, "正常"),
    USED(1, "使用过"),
    P2P(2, "P2P"),
    LIQUID(3, "流动性"),
    PRICELOW(4, "最优价");
    
    public int code;
    public String value;

    private QuoteInfoTagEnum(int i11, String str) {
        this.code = i11;
        this.value = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}
