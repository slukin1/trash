package com.hbg.lib.network.pro.core.util;

public enum DepthType {
    STEP0("step0"),
    STEP1("step1"),
    STEP2("step2"),
    PERCENT10("percent10");
    
    public final String step;

    private DepthType(String str) {
        this.step = str;
    }
}
