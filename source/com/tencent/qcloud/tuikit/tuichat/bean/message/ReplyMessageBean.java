package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;

public class ReplyMessageBean extends QuoteMessageBean {
    private final String msgRootId;

    public ReplyMessageBean(ReplyPreviewBean replyPreviewBean) {
        super(replyPreviewBean);
        this.msgRootId = replyPreviewBean.getMessageRootID();
    }

    public String getMsgRootId() {
        return this.msgRootId;
    }
}
