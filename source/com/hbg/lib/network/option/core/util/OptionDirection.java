package com.hbg.lib.network.option.core.util;

public enum OptionDirection {
    BUY("buy"),
    SELL("sell");
    
    public String direction;

    private OptionDirection(String str) {
        this.direction = str;
    }
}
