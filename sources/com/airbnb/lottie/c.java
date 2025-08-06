package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f13992b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f13993c;

    public /* synthetic */ c(LottieAnimationView lottieAnimationView, int i11) {
        this.f13992b = lottieAnimationView;
        this.f13993c = i11;
    }

    public final Object call() {
        return this.f13992b.lambda$fromRawRes$1(this.f13993c);
    }
}
