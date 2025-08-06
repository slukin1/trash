package com.huobi.index.ui;

import android.view.View;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment f73955b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f73956c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f73957d;

    public /* synthetic */ o(IndexFragment indexFragment, int i11, int i12) {
        this.f73955b = indexFragment;
        this.f73956c = i11;
        this.f73957d = i12;
    }

    public final void onClick(View view) {
        this.f73955b.il(this.f73956c, this.f73957d, view);
    }
}
