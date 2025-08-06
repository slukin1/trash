package com.huobi.index.ui;

import android.view.View;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment f73943b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f73944c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f73945d;

    public /* synthetic */ m(IndexFragment indexFragment, int i11, int i12) {
        this.f73943b = indexFragment;
        this.f73944c = i11;
        this.f73945d = i12;
    }

    public final void onClick(View view) {
        this.f73943b.fl(this.f73944c, this.f73945d, view);
    }
}
