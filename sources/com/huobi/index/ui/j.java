package com.huobi.index.ui;

import android.view.View;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment f73905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f73906c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f73907d;

    public /* synthetic */ j(IndexFragment indexFragment, int i11, int i12) {
        this.f73905b = indexFragment;
        this.f73906c = i11;
        this.f73907d = i12;
    }

    public final void onClick(View view) {
        this.f73905b.gl(this.f73906c, this.f73907d, view);
    }
}
