package com.huobi.otc.enums;

public enum OtcWsReceiveAction {
    Action_200(200),
    Action_401(401),
    Action_429(429),
    Action_1000(1000),
    Action_1001(1001),
    Action_1002(1002),
    Action_1003(1003),
    Action_1004(1004),
    Action_1005(1005);
    
    private int value;

    private OtcWsReceiveAction(int i11) {
        this.value = i11;
    }

    public int getValue() {
        return this.value;
    }
}
