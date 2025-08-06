package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class OtcMainContentRootLayout extends FrameLayout {
    public OtcMainContentRootLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public OtcMainContentRootLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setTag(OtcMainContentRootLayout.class.getName());
    }
}
