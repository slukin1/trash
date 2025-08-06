package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class w implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14044a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f14045b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14046c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f14047d;

    public /* synthetic */ w(LottieDrawable lottieDrawable, String str, String str2, boolean z11) {
        this.f14044a = lottieDrawable;
        this.f14045b = str;
        this.f14046c = str2;
        this.f14047d = z11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14044a.lambda$setMinAndMaxFrame$9(this.f14045b, this.f14046c, this.f14047d, lottieComposition);
    }
}
