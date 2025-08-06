package com.hbg.lib.network.option.core.util;

public enum OptionTriggerType {
    GE("ge"),
    LE("le");
    
    public String type;

    private OptionTriggerType(String str) {
        this.type = str;
    }
}
