package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class d0 implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f13998a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13999b;

    public /* synthetic */ d0(LottieDrawable lottieDrawable, int i11) {
        this.f13998a = lottieDrawable;
        this.f13999b = i11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f13998a.lambda$setFrame$12(this.f13999b, lottieComposition);
    }
}
