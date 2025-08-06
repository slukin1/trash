package com.hbg.lib.network.otc.core.wsbean;

import com.hbg.lib.network.retrofit.websocketnew.base.AbsOtcSocketType;

public class PChatChannelBean extends AbsOtcSocketType {
    private String orderId;

    public PChatChannelBean(String str) {
        this.orderId = str;
    }

    public int getAction() {
        return 2008;
    }

    public int getBusinessChannel() {
        return 1;
    }

    public String getContent() {
        return "2";
    }

    public String getExtra() {
        return this.orderId;
    }
}
