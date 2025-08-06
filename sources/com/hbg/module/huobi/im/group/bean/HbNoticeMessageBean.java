package com.hbg.module.huobi.im.group.bean;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;

public class HbNoticeMessageBean extends TextMessageBean {
    private String groupId;
    private String noticeMsg;

    public String getGroupId() {
        return this.groupId;
    }

    public int getMsgType() {
        return 1;
    }

    public String getNoticeMsg() {
        return this.noticeMsg;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setNoticeMsg(String str) {
        this.noticeMsg = str;
    }
}
