package com.hbg.module.content.ui.activity.live;

import android.view.ViewTreeObserver;

public final /* synthetic */ class g0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveDetailActivity f18639b;

    public /* synthetic */ g0(LiveDetailActivity liveDetailActivity) {
        this.f18639b = liveDetailActivity;
    }

    public final void onScrollChanged() {
        LiveDetailActivity.rk(this.f18639b);
    }
}
