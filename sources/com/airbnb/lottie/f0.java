package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class f0 implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14006a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f14007b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f14008c;

    public /* synthetic */ f0(LottieDrawable lottieDrawable, int i11, int i12) {
        this.f14006a = lottieDrawable;
        this.f14007b = i11;
        this.f14008c = i12;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14006a.lambda$setMinAndMaxFrame$10(this.f14007b, this.f14008c, lottieComposition);
    }
}
