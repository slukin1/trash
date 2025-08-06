package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class q0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexRankSubTextListIndicator f72279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f72280c;

    public /* synthetic */ q0(IndexRankSubTextListIndicator indexRankSubTextListIndicator, int i11) {
        this.f72279b = indexRankSubTextListIndicator;
        this.f72280c = i11;
    }

    public final void onClick(View view) {
        this.f72279b.r(this.f72280c, view);
    }
}
