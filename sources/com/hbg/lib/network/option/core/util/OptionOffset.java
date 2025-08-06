package com.hbg.lib.network.option.core.util;

public enum OptionOffset {
    OPEN("open"),
    CLOSE("close");
    
    public String offset;

    private OptionOffset(String str) {
        this.offset = str;
    }
}
