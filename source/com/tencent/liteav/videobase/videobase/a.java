package com.tencent.liteav.videobase.videobase;

import android.view.View;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final View f22283a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22284b;

    private a(View view, int i11) {
        this.f22283a = view;
        this.f22284b = i11;
    }

    public static Runnable a(View view, int i11) {
        return new a(view, i11);
    }

    public final void run() {
        this.f22283a.setVisibility(this.f22284b);
    }
}
