package com.huobi.home.ui;

import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class d implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f72551b;

    public /* synthetic */ d(HomeFragment homeFragment) {
        this.f72551b = homeFragment;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        HomeFragment.di(this.f72551b, appBarLayout, i11);
    }
}
