package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class u0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexTextListIndicator f72408b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f72409c;

    public /* synthetic */ u0(IndexTextListIndicator indexTextListIndicator, int i11) {
        this.f72408b = indexTextListIndicator;
        this.f72409c = i11;
    }

    public final void onClick(View view) {
        this.f72408b.m(this.f72409c, view);
    }
}
