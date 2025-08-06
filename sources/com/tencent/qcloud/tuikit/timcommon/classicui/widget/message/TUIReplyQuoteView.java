package com.tencent.qcloud.tuikit.timcommon.classicui.widget.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;

public abstract class TUIReplyQuoteView<T extends TUIReplyQuoteBean<?>> extends FrameLayout {
    public TUIReplyQuoteView(Context context) {
        super(context);
        int layoutResourceId = getLayoutResourceId();
        if (layoutResourceId != 0) {
            LayoutInflater.from(context).inflate(layoutResourceId, this, true);
        }
    }

    public abstract int getLayoutResourceId();

    public abstract void onDrawReplyQuote(T t11);

    public void setSelf(boolean z11) {
    }
}
