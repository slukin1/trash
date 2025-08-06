package com.hbg.module.huobi.im.group.bean;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;

public class HbTipMessageBean extends TextMessageBean {
    private String text;

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return TextReplyQuoteBean.class;
    }

    public String getText() {
        return this.text;
    }

    public String onGetDisplayString() {
        return this.text;
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage.getTextElem() != null) {
            this.text = v2TIMMessage.getTextElem().getText();
        }
        setExtra(this.text);
    }

    public void setText(String str) {
        this.text = str;
    }
}
