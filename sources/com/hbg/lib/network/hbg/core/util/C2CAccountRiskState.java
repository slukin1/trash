package com.hbg.lib.network.hbg.core.util;

public enum C2CAccountRiskState {
    NEGATIVE(-1),
    LIQUIDATION(0),
    HIGH(1),
    HAVE(2),
    NO(3);
    
    public final int state;

    private C2CAccountRiskState(int i11) {
        this.state = i11;
    }
}
