package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class u implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14039a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f14040b;

    public /* synthetic */ u(LottieDrawable lottieDrawable, String str) {
        this.f14039a = lottieDrawable;
        this.f14040b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14039a.lambda$setMaxFrame$7(this.f14040b, lottieComposition);
    }
}
