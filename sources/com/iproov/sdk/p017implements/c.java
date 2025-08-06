package com.iproov.sdk.p017implements;

import android.animation.ValueAnimator;
import d10.l;

/* renamed from: com.iproov.sdk.implements.c  reason: invalid package */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f38862b;

    public /* synthetic */ c(l lVar) {
        this.f38862b = lVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Cdo.m995if(this.f38862b, valueAnimator);
    }
}
