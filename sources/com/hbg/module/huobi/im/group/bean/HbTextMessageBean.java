package com.hbg.module.huobi.im.group.bean;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;

public class HbTextMessageBean extends TextMessageBean {
    private boolean isCount;
    private String selectText;
    private String text;
    private String translateText;

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return TextReplyQuoteBean.class;
    }

    public String getSelectText() {
        return this.selectText;
    }

    public String getText() {
        return this.text;
    }

    public String getTranslateText() {
        return this.translateText;
    }

    public boolean isCount() {
        return this.isCount;
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

    public void setCount(boolean z11) {
        this.isCount = z11;
    }

    public void setSelectText(String str) {
        this.selectText = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTranslateText(String str) {
        this.translateText = str;
    }
}
