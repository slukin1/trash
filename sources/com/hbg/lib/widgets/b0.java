package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class b0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonTextListIndicator f71749b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f71750c;

    public /* synthetic */ b0(CommonTextListIndicator commonTextListIndicator, int i11) {
        this.f71749b = commonTextListIndicator;
        this.f71750c = i11;
    }

    public final void onClick(View view) {
        this.f71749b.u(this.f71750c, view);
    }
}
