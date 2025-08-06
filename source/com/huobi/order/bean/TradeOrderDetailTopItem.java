package com.huobi.order.bean;

import android.view.View;
import com.huobi.order.handler.TradeOrderHistoryTopHandler;
import java.io.Serializable;
import s9.a;

public class TradeOrderDetailTopItem implements Serializable, a {
    public String content;
    public View.OnClickListener contentClickListener;
    public int contentRightRes;
    public String title;
    public View.OnClickListener titleClickListener;
    public int titleRightRes;

    public TradeOrderDetailTopItem(String str, String str2) {
        this.title = str;
        this.content = str2;
    }

    public String getViewHandlerName() {
        return TradeOrderHistoryTopHandler.class.getName();
    }

    public TradeOrderDetailTopItem setContent(String str) {
        this.content = str;
        return this;
    }

    public TradeOrderDetailTopItem setContentClickListener(View.OnClickListener onClickListener) {
        this.contentClickListener = onClickListener;
        return this;
    }

    public TradeOrderDetailTopItem setContentRightRes(int i11) {
        this.contentRightRes = i11;
        return this;
    }

    public TradeOrderDetailTopItem setTitle(String str) {
        this.title = str;
        return this;
    }

    public TradeOrderDetailTopItem setTitleClickListener(View.OnClickListener onClickListener) {
        this.titleClickListener = onClickListener;
        return this;
    }

    public TradeOrderDetailTopItem setTitleRightRes(int i11) {
        this.titleRightRes = i11;
        return this;
    }
}
