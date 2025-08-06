package com.sumsub.sns.core.widget;

import android.animation.ValueAnimator;

public final /* synthetic */ class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSLivenessFaceView f31262b;

    public /* synthetic */ q(SNSLivenessFaceView sNSLivenessFaceView) {
        this.f31262b = sNSLivenessFaceView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SNSLivenessFaceView.m30progressRotationAnimator$lambda8$lambda7(this.f31262b, valueAnimator);
    }
}
