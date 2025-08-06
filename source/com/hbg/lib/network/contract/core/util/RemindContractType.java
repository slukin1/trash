package com.hbg.lib.network.contract.core.util;

public enum RemindContractType {
    TYPE_CURRENT_WEEK(1),
    TYPE_NEXT_WEEK(2),
    TYPE_CURRENT_SEASON(3),
    TYPE_NEXT_SEASON(4),
    TYPE_SWAP(5),
    TYPE_LINEAR_SWAP(6);
    
    public final int type;

    private RemindContractType(int i11) {
        this.type = i11;
    }

    public static RemindContractType parse(int i11) {
        if (i11 == 1) {
            return TYPE_CURRENT_WEEK;
        }
        if (i11 == 2) {
            return TYPE_NEXT_WEEK;
        }
        if (i11 == 3) {
            return TYPE_CURRENT_SEASON;
        }
        if (i11 == 4) {
            return TYPE_NEXT_SEASON;
        }
        if (i11 != 5) {
            return TYPE_LINEAR_SWAP;
        }
        return TYPE_SWAP;
    }
}
