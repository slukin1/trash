package com.hbg.module.content.utls;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class s implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TipsPopDialog f18952b;

    public /* synthetic */ s(TipsPopDialog tipsPopDialog) {
        this.f18952b = tipsPopDialog;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TipsPopDialog.f(this.f18952b, view, motionEvent);
    }
}
