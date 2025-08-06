package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import rj.n;

public class RootContainerView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public String f44095b;

    /* renamed from: c  reason: collision with root package name */
    public n f44096c;

    public RootContainerView(Context context) {
        super(context);
    }

    public n getEngineContext() {
        return this.f44096c;
    }

    public RootContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RootContainerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
