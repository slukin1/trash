package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import rj.n;

public class FrameWidget extends NodeSequenceWidget {
    /* renamed from: b0 */
    public ViewGroup Q(Context context, n nVar) {
        ViewGroup b02 = super.Q(context, nVar);
        c0(b02, this.f44094j0);
        return b02;
    }

    public View q(Context context) {
        return new FrameLayout(context);
    }
}
