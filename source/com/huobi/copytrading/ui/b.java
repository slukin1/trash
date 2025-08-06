package com.huobi.copytrading.ui;

import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class b implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CopyTradingHomeFragment f43685b;

    public /* synthetic */ b(CopyTradingHomeFragment copyTradingHomeFragment) {
        this.f43685b = copyTradingHomeFragment;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        CopyTradingHomeFragment.Ph(this.f43685b, appBarLayout, i11);
    }
}
