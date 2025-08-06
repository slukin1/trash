package com.zendesk.util;

public enum NumberFormatUtil$NumberSuffix {
    NONE(""),
    KILO("k"),
    MEGA("M"),
    GIGA("G"),
    TERA("T"),
    PETA("P"),
    EXA("E");
    
    private String suffix;

    private NumberFormatUtil$NumberSuffix(String str) {
        this.suffix = str;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
