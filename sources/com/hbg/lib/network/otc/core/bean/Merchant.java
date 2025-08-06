package com.hbg.lib.network.otc.core.bean;

public enum Merchant {
    NONE(""),
    NORMAL("general"),
    SUPER("block");
    
    public final String value;

    private Merchant(String str) {
        this.value = str;
    }

    public static Merchant parseMerchant(String str) {
        Merchant merchant = NORMAL;
        if (merchant.value.equalsIgnoreCase(str) || "1".equalsIgnoreCase(str)) {
            return merchant;
        }
        Merchant merchant2 = SUPER;
        return (merchant2.value.equalsIgnoreCase(str) || "3".equalsIgnoreCase(str)) ? merchant2 : merchant;
    }
}
