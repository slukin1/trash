package com.tencent.qcloud.tuikit.timcommon.bean;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import java.io.Serializable;

public abstract class TUIReplyQuoteBean<T extends TUIMessageBean> implements Serializable {
    public String defaultAbstract;
    private T messageBean;
    public int messageType;

    public String getDefaultAbstract() {
        return this.defaultAbstract;
    }

    public T getMessageBean() {
        return this.messageBean;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public Class<? extends TUIReplyQuoteView> getReplyQuoteViewClass() {
        return null;
    }

    public abstract void onProcessReplyQuoteBean(T t11);

    public void setDefaultAbstract(String str) {
        this.defaultAbstract = str;
    }

    public void setMessageBean(T t11) {
        this.messageBean = t11;
    }

    public void setMessageType(int i11) {
        this.messageType = i11;
    }
}
