package com.hbg.lib.network.hbg.core.util;

public enum C2CTransferDirect {
    IN("in"),
    OUT("out");
    
    public final String state;

    private C2CTransferDirect(String str) {
        this.state = str;
    }
}
