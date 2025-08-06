package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class b0 implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f13989a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f13990b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f13991c;

    public /* synthetic */ b0(LottieDrawable lottieDrawable, float f11, float f12) {
        this.f13989a = lottieDrawable;
        this.f13990b = f11;
        this.f13991c = f12;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f13989a.lambda$setMinAndMaxProgress$11(this.f13990b, this.f13991c, lottieComposition);
    }
}
