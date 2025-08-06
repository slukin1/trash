package com.hbg.module.huobi.im.group.bean;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;

public class HbAccountManagerUnreadBean extends TextMessageBean {
    public int getMsgType() {
        return 1;
    }
}
