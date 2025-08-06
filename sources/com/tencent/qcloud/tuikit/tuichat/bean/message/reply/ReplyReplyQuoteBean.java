package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;

public class ReplyReplyQuoteBean extends TextReplyQuoteBean {
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof QuoteMessageBean) {
            setText(tUIMessageBean.getExtra());
        }
    }
}
