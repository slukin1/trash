package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f21672a;

    private l(g gVar) {
        this.f21672a = gVar;
    }

    public static Runnable a(g gVar) {
        return new l(gVar);
    }

    public final void run() {
        ScrollView scrollView = this.f21672a.f21656k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
