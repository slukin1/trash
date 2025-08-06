package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class c0 implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f13994a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13995b;

    public /* synthetic */ c0(LottieDrawable lottieDrawable, int i11) {
        this.f13994a = lottieDrawable;
        this.f13995b = i11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f13994a.lambda$setMinFrame$2(this.f13995b, lottieComposition);
    }
}
