package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;

public class CustomLinkReplyQuoteBean extends TextReplyQuoteBean {
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof CustomLinkMessageBean) {
            setText(((CustomLinkMessageBean) tUIMessageBean).getText());
        }
    }
}
