package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonWrapTextListIndicator f71953b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f71954c;

    public /* synthetic */ e0(CommonWrapTextListIndicator commonWrapTextListIndicator, int i11) {
        this.f71953b = commonWrapTextListIndicator;
        this.f71954c = i11;
    }

    public final void onClick(View view) {
        this.f71953b.r(this.f71954c, view);
    }
}
