package com.huobi.view.pickerview;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class d implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BasePickerView f19092b;

    public /* synthetic */ d(BasePickerView basePickerView) {
        this.f19092b = basePickerView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f19092b.lambda$new$3(view, motionEvent);
    }
}
