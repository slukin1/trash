package com.hbg.lib.network.option.core.util;

public enum OptionDepthType {
    PERCENT10("percent10"),
    STEP6("step6");
    
    public final String step;

    private OptionDepthType(String str) {
        this.step = str;
    }
}
