package com.huobi.otc.enums;

public enum OtcReceiveOrderStatus {
    ACCEPT_WAITING(108, "accept_waiting"),
    ACCEPT_CANCEL(109, "accept_cancel"),
    ACCEPT_REFUSE(110, "accept_refuse");
    
    public int statusCode;
    public String statusValue;

    private OtcReceiveOrderStatus(int i11, String str) {
        this.statusCode = i11;
        this.statusValue = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusValue() {
        return this.statusValue;
    }
}
