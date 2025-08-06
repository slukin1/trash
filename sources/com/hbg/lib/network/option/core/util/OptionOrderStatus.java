package com.hbg.lib.network.option.core.util;

public enum OptionOrderStatus {
    PREPARE(3),
    PARTICAL(4),
    PARTICAL_CANCELED(5),
    FILLED(6),
    CANCELED(7);
    
    public int status;

    private OptionOrderStatus(int i11) {
        this.status = i11;
    }
}
