package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomOrderMessageBean;

public class CustomOrderMessageReplyQuoteBean extends TextReplyQuoteBean {
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof CustomOrderMessageBean) {
            setText(((CustomOrderMessageBean) tUIMessageBean).getDescription());
        }
    }
}
