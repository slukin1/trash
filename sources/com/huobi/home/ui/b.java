package com.huobi.home.ui;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class b implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f72549b;

    public /* synthetic */ b(HomeFragment homeFragment) {
        this.f72549b = homeFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return HomeFragment.ki(this.f72549b, view, motionEvent);
    }
}
