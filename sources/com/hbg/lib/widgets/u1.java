package com.hbg.lib.widgets;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class u1 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TopScrollView f72410b;

    public /* synthetic */ u1(TopScrollView topScrollView) {
        this.f72410b = topScrollView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f72410b.e(view, motionEvent);
    }
}
