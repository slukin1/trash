package com.tencent.liteav.videobase.videobase;

import android.view.View;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final View f22285a;

    private b(View view) {
        this.f22285a = view;
    }

    public static Runnable a(View view) {
        return new b(view);
    }

    public final void run() {
        this.f22285a.requestLayout();
    }
}
