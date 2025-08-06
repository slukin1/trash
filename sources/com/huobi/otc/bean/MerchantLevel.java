package com.huobi.otc.bean;

public enum MerchantLevel {
    NONE(0),
    NORMAL(1),
    AUTH(2),
    SUPER(3);
    
    public int value;

    private MerchantLevel(int i11) {
        this.value = i11;
    }

    public static MerchantLevel parseMerchant(int i11) {
        if (i11 == 1) {
            return NORMAL;
        }
        if (i11 == 2) {
            return AUTH;
        }
        if (i11 != 3) {
            return NONE;
        }
        return SUPER;
    }
}
