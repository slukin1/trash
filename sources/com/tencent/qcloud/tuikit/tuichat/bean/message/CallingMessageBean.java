package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;

public class CallingMessageBean extends TextMessageBean {
    public static final int ACTION_ID_AUDIO_CALL = 1;
    public static final int ACTION_ID_VIDEO_CALL = 2;
    private int callType;
    private boolean isCaller;
    private boolean isShowUnreadPoint;
    private String text;

    public int getCallType() {
        return this.callType;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return TextReplyQuoteBean.class;
    }

    public String getText() {
        return this.text;
    }

    public boolean isSelf() {
        return this.isCaller;
    }

    public boolean isShowUnreadPoint() {
        return this.isShowUnreadPoint;
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

    public void setCallType(int i11) {
        this.callType = i11;
    }

    public void setCaller(boolean z11) {
        this.isCaller = z11;
    }

    public void setShowUnreadPoint(boolean z11) {
        this.isShowUnreadPoint = z11;
    }

    public void setText(String str) {
        this.text = str;
    }
}
