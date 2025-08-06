package com.huobi.otc.bean;

public enum OtcOrderTradeInstructionStatus {
    init("INIT"),
    waitConfirm("WAIT_CONFIRM"),
    confirmed("CONFIRMED");
    
    public final String value;

    private OtcOrderTradeInstructionStatus(String str) {
        this.value = str;
    }
}
