package com.twitter.sdk.android.tweetui.internal;

import android.animation.ValueAnimator;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwipeToDismissTouchListener f51234b;

    public /* synthetic */ c(SwipeToDismissTouchListener swipeToDismissTouchListener) {
        this.f51234b = swipeToDismissTouchListener;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f51234b.lambda$settleView$0(valueAnimator);
    }
}
