package com.huobi.zeroswap.engine.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import com.hbg.component.kline.view.RenderView;

public class RenderEdgeItemView extends RenderView {
    public RenderEdgeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onAttachedToWindow() {
    }

    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
    }

    public RenderEdgeItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        getRender().onAttachedToWindow();
    }
}
