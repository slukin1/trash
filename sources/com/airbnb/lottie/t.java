package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class t implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14037a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f14038b;

    public /* synthetic */ t(LottieDrawable lottieDrawable, String str) {
        this.f14037a = lottieDrawable;
        this.f14038b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14037a.lambda$setMinFrame$6(this.f14038b, lottieComposition);
    }
}
