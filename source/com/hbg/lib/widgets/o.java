package com.hbg.lib.widgets;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class o implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonEditText f72109b;

    public /* synthetic */ o(CommonEditText commonEditText) {
        this.f72109b = commonEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f72109b.g(view, motionEvent);
    }
}
