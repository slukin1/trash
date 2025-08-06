package com.hbg.module.livesquare.ui;

import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class k implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecommendSpeakerActivity f26663b;

    public /* synthetic */ k(RecommendSpeakerActivity recommendSpeakerActivity) {
        this.f26663b = recommendSpeakerActivity;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        RecommendSpeakerActivity.Gh(this.f26663b, appBarLayout, i11);
    }
}
