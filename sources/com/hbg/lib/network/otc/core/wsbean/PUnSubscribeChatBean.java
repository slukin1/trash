package com.hbg.lib.network.otc.core.wsbean;

import com.hbg.lib.network.retrofit.websocketnew.base.AbsOtcSocketType;

public class PUnSubscribeChatBean extends AbsOtcSocketType {
    private String orderId;

    public PUnSubscribeChatBean(String str) {
        this.orderId = str;
    }

    public int getAction() {
        return 2004;
    }

    public int getBusinessChannel() {
        return 1;
    }

    public String getContent() {
        return "3";
    }
}
