package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class a0 implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f13985a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f13986b;

    public /* synthetic */ a0(LottieDrawable lottieDrawable, float f11) {
        this.f13985a = lottieDrawable;
        this.f13986b = f11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f13985a.lambda$setProgress$13(this.f13986b, lottieComposition);
    }
}
