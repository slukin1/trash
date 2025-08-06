package com.hbg.lib.network.swap.core.util;

public enum SwapDepthType {
    PERCENT10("percent10"),
    STEP6("step6");
    
    public final String step;

    private SwapDepthType(String str) {
        this.step = str;
    }
}
