package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class f0 implements View.OnScrollChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommonWrapTextListIndicator f72032a;

    public /* synthetic */ f0(CommonWrapTextListIndicator commonWrapTextListIndicator) {
        this.f72032a = commonWrapTextListIndicator;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        this.f72032a.s(view, i11, i12, i13, i14);
    }
}
