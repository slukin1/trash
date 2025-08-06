package com.hbg.module.content.custom;

import android.view.View;
import lc.k0;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k0 f18131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveRecommendDialog f18132c;

    public /* synthetic */ h(k0 k0Var, LiveRecommendDialog liveRecommendDialog) {
        this.f18131b = k0Var;
        this.f18132c = liveRecommendDialog;
    }

    public final void onClick(View view) {
        LiveRecommendDialog.vh(this.f18131b, this.f18132c, view);
    }
}
