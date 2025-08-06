package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class v implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14042a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f14043b;

    public /* synthetic */ v(LottieDrawable lottieDrawable, String str) {
        this.f14042a = lottieDrawable;
        this.f14043b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14042a.lambda$setMinAndMaxFrame$8(this.f14043b, lottieComposition);
    }
}
