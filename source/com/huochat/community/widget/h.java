package com.huochat.community.widget;

import com.google.android.material.appbar.AppBarLayout;
import com.nineoldandroids.animation.ValueAnimator;

public final /* synthetic */ class h implements ValueAnimator.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.Behavior f38725a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f38726b;

    public /* synthetic */ h(AppBarLayout.Behavior behavior, int i11) {
        this.f38725a = behavior;
        this.f38726b = i11;
    }

    public final void a(ValueAnimator valueAnimator) {
        this.f38725a.setTopAndBottomOffset(this.f38726b + ((Integer) valueAnimator.v()).intValue());
    }
}
