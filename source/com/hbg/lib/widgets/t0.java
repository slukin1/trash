package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class t0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexTextListCompactIndicator f72307b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f72308c;

    public /* synthetic */ t0(IndexTextListCompactIndicator indexTextListCompactIndicator, int i11) {
        this.f72307b = indexTextListCompactIndicator;
        this.f72308c = i11;
    }

    public final void onClick(View view) {
        this.f72307b.j(this.f72308c, view);
    }
}
