package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f21667a;

    private h(g gVar) {
        this.f21667a = gVar;
    }

    public static Runnable a(g gVar) {
        return new h(gVar);
    }

    public final void run() {
        ScrollView scrollView = this.f21667a.f21656k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
