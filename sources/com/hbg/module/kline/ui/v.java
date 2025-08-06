package com.hbg.module.kline.ui;

import android.view.View;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractKlineFragment f24286b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f24287c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int[] f24288d;

    public /* synthetic */ v(AbstractKlineFragment abstractKlineFragment, View view, int[] iArr) {
        this.f24286b = abstractKlineFragment;
        this.f24287c = view;
        this.f24288d = iArr;
    }

    public final void run() {
        this.f24286b.Hi(this.f24287c, this.f24288d);
    }
}
