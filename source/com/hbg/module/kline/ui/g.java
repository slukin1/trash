package com.hbg.module.kline.ui;

import android.view.View;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractKlineActivity f24186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f24187c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int[] f24188d;

    public /* synthetic */ g(AbstractKlineActivity abstractKlineActivity, View view, int[] iArr) {
        this.f24186b = abstractKlineActivity;
        this.f24187c = view;
        this.f24188d = iArr;
    }

    public final void run() {
        this.f24186b.li(this.f24187c, this.f24188d);
    }
}
