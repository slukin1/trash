package com.hbg.module.huobi.im.group.bean;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;

public class HbShareMessageBean extends TextMessageBean {
    public static final int SHARE_IMAGE_TYPE = 1;
    public static final int TEXT_BODY_TYPE = 0;
    public String groupId;
    public String shareActionTitle;
    public String shareActionUrl;
    public int shareImageHeight;
    public String shareImageUrl;
    public int shareImageWidth;
    public String shareText;
    public int type = 0;

    public String getGroupId() {
        return super.getGroupId();
    }

    public int getMsgType() {
        return 1;
    }

    public String getNoticeMsg() {
        return this.shareText;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setNoticeMsg(String str) {
        this.shareText = str;
    }
}
