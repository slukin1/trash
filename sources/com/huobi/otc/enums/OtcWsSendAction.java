package com.huobi.otc.enums;

public enum OtcWsSendAction {
    action_2000(2000),
    action_2002(2002),
    action_2003(2003),
    action_2004(2004),
    action_2005(2005);
    
    private int value;

    private OtcWsSendAction(int i11) {
        this.value = i11;
    }

    public int getValue() {
        return this.value;
    }
}
