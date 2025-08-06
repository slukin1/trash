package com.hbg.lib.network.otc.core.wsbean;

import com.hbg.lib.network.retrofit.websocketnew.base.AbsOtcSocketType;

public class SubOtcOrderReminderSend extends AbsOtcSocketType {
    public int getAction() {
        return 2003;
    }

    public int getBusinessChannel() {
        return 1;
    }

    public String getContent() {
        return "3";
    }
}
