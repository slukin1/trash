package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;

public class TextReplyQuoteBean extends TUIReplyQuoteBean {
    private String text;

    public String getText() {
        return this.text;
    }

    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof TextMessageBean) {
            this.text = ((TextMessageBean) tUIMessageBean).getText();
        }
    }

    public void setText(String str) {
        this.text = str;
    }
}
