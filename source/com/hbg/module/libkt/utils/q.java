package com.hbg.module.libkt.utils;

import android.view.View;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f24936b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f24937c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f24938d;

    public /* synthetic */ q(View view, long j11, View.OnClickListener onClickListener) {
        this.f24936b = view;
        this.f24937c = j11;
        this.f24938d = onClickListener;
    }

    public final void onClick(View view) {
        r.h(this.f24936b, this.f24937c, this.f24938d, view);
    }
}
