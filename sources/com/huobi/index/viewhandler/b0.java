package com.huobi.index.viewhandler;

import android.view.View;
import android.widget.LinearLayout;

public final /* synthetic */ class b0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f74435b;

    public /* synthetic */ b0(LinearLayout linearLayout) {
        this.f74435b = linearLayout;
    }

    public final void onClick(View view) {
        NewsTopicHandler.d(this.f74435b, view);
    }
}
