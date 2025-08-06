package com.huobi.asset.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hbg.module.asset.R$layout;

public class StickFilterBar extends FrameLayout {
    public StickFilterBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        View.inflate(context, R$layout.item_asset_sticky_filter, this);
    }

    public StickFilterBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
