package com.hbg.module.kline.ui;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class v2 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment f24291b;

    public /* synthetic */ v2(MarketInfoFragment marketInfoFragment) {
        this.f24291b = marketInfoFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f24291b.pl(view, motionEvent);
    }
}
