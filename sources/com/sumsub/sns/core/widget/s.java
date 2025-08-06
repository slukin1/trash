package com.sumsub.sns.core.widget;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Ref$FloatRef;

public final /* synthetic */ class s implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f31264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f31265c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SNSRotationZoomableImageView f31266d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Ref$FloatRef f31267e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ float f31268f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f31269g;

    public /* synthetic */ s(float f11, float f12, SNSRotationZoomableImageView sNSRotationZoomableImageView, Ref$FloatRef ref$FloatRef, float f13, float f14) {
        this.f31264b = f11;
        this.f31265c = f12;
        this.f31266d = sNSRotationZoomableImageView;
        this.f31267e = ref$FloatRef;
        this.f31268f = f13;
        this.f31269g = f14;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SNSRotationZoomableImageView.m33animateScale$lambda7$lambda6(this.f31264b, this.f31265c, this.f31266d, this.f31267e, this.f31268f, this.f31269g, valueAnimator);
    }
}
