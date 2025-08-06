package com.hbg.lib.network.contract.core.util;

public enum ContractDepthType {
    PERCENT10("percent10"),
    STEP6("step6");
    
    public final String step;

    private ContractDepthType(String str) {
        this.step = str;
    }
}
