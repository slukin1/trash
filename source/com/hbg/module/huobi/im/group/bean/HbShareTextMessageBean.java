package com.hbg.module.huobi.im.group.bean;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;

public class HbShareTextMessageBean extends TextMessageBean {
    public static final int SHARE_TEXT_TYPE = 1;
    public static final int TEXT_BODY_TYPE = 0;
    public String groupId;
    public String shareContent;
    public String shareText;
    public int type;

    public String getGroupId() {
        return super.getGroupId();
    }

    public int getMsgType() {
        return 1;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
