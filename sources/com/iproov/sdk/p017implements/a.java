package com.iproov.sdk.p017implements;

import android.animation.ValueAnimator;
import d10.l;

/* renamed from: com.iproov.sdk.implements.a  reason: invalid package */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f38860b;

    public /* synthetic */ a(l lVar) {
        this.f38860b = lVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Cdo.m994for(this.f38860b, valueAnimator);
    }
}
