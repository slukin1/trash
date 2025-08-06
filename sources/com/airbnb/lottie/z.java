package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class z implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14051a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f14052b;

    public /* synthetic */ z(LottieDrawable lottieDrawable, float f11) {
        this.f14051a = lottieDrawable;
        this.f14052b = f11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14051a.lambda$setMinProgress$3(this.f14052b, lottieComposition);
    }
}
