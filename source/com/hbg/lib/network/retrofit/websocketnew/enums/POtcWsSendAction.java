package com.hbg.lib.network.retrofit.websocketnew.enums;

public enum POtcWsSendAction {
    action_2000(2000),
    action_2002(2002),
    action_2003(2003),
    action_2004(2004),
    action_2005(2005);
    
    private int value;

    private POtcWsSendAction(int i11) {
        this.value = i11;
    }

    public int getValue() {
        return this.value;
    }
}
