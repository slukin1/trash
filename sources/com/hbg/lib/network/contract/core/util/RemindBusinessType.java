package com.hbg.lib.network.contract.core.util;

public enum RemindBusinessType {
    CONTRACT(1),
    SWAP(2),
    LINEAR_SWAP(3);
    
    public final int type;

    private RemindBusinessType(int i11) {
        this.type = i11;
    }

    public static RemindBusinessType parse(int i11) {
        if (i11 == 1) {
            return CONTRACT;
        }
        if (i11 != 2) {
            return LINEAR_SWAP;
        }
        return SWAP;
    }
}
