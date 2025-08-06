package com.twitter.sdk.android.tweetui.internal;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MultiTouchImageView f51230b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f51231c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f51232d;

    public /* synthetic */ a(MultiTouchImageView multiTouchImageView, float f11, float f12) {
        this.f51230b = multiTouchImageView;
        this.f51231c = f11;
        this.f51232d = f12;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f51230b.lambda$animateScale$0(this.f51231c, this.f51232d, valueAnimator);
    }
}
