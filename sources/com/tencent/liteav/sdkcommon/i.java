package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f21668a;

    private i(g gVar) {
        this.f21668a = gVar;
    }

    public static Runnable a(g gVar) {
        return new i(gVar);
    }

    public final void run() {
        ScrollView scrollView = this.f21668a.f21656k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
