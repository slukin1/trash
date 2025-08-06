package com.huobi.view;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class m1 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectorDialogFragment f19074b;

    public /* synthetic */ m1(SelectorDialogFragment selectorDialogFragment) {
        this.f19074b = selectorDialogFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f19074b.lambda$addEvent$0(view, motionEvent);
    }
}
