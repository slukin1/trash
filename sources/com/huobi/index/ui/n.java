package com.huobi.index.ui;

import android.view.View;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment f73948b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f73949c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f73950d;

    public /* synthetic */ n(IndexFragment indexFragment, int i11, int i12) {
        this.f73948b = indexFragment;
        this.f73949c = i11;
        this.f73950d = i12;
    }

    public final void onClick(View view) {
        this.f73948b.hl(this.f73949c, this.f73950d, view);
    }
}
