package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class e0 implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14002a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f14003b;

    public /* synthetic */ e0(LottieDrawable lottieDrawable, int i11) {
        this.f14002a = lottieDrawable;
        this.f14003b = i11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14002a.lambda$setMaxFrame$4(this.f14003b, lottieComposition);
    }
}
