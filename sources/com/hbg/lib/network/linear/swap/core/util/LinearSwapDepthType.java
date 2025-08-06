package com.hbg.lib.network.linear.swap.core.util;

public enum LinearSwapDepthType {
    PERCENT10("percent10"),
    STEP6("step6");
    
    public final String step;

    private LinearSwapDepthType(String str) {
        this.step = str;
    }
}
