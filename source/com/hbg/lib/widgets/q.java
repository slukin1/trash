package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonKeyboardView f72277b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f72278c;

    public /* synthetic */ q(CommonKeyboardView commonKeyboardView, String str) {
        this.f72277b = commonKeyboardView;
        this.f72278c = str;
    }

    public final void onClick(View view) {
        this.f72277b.d(this.f72278c, view);
    }
}
