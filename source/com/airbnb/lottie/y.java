package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class y implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14049a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f14050b;

    public /* synthetic */ y(LottieDrawable lottieDrawable, float f11) {
        this.f14049a = lottieDrawable;
        this.f14050b = f11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14049a.lambda$setMaxProgress$5(this.f14050b, lottieComposition);
    }
}
