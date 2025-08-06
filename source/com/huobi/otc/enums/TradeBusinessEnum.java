package com.huobi.otc.enums;

public enum TradeBusinessEnum {
    ALL("0000", TtmlNode.COMBINE_ALL),
    P2P("B10000", "p2p"),
    BIND_CARD("B11000", "bindCard"),
    BALANCE("B13000", "balance"),
    APM("B17000", "apm"),
    THIRD("B14000", "third");
    
    public String code;
    public String value;

    private TradeBusinessEnum(String str, String str2) {
        this.code = str;
        this.value = str2;
    }
}
