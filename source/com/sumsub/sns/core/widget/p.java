package com.sumsub.sns.core.widget;

import android.animation.ValueAnimator;

public final /* synthetic */ class p implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSLivenessFaceView f31261b;

    public /* synthetic */ p(SNSLivenessFaceView sNSLivenessFaceView) {
        this.f31261b = sNSLivenessFaceView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SNSLivenessFaceView.m32updater$lambda2(this.f31261b, valueAnimator);
    }
}
