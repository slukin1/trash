package com.huobi.home.ui;

import android.view.ViewTreeObserver;

public final /* synthetic */ class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f72550b;

    public /* synthetic */ c(HomeFragment homeFragment) {
        this.f72550b = homeFragment;
    }

    public final void onGlobalLayout() {
        HomeFragment.ci(this.f72550b);
    }
}
