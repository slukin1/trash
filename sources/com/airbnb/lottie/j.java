package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final /* synthetic */ class j implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f14018b;

    public /* synthetic */ j(LottieComposition lottieComposition) {
        this.f14018b = lottieComposition;
    }

    public final Object call() {
        return LottieCompositionFactory.lambda$cache$8(this.f14018b);
    }
}
