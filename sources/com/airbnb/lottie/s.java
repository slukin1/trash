package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;

public final /* synthetic */ class s implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14033a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyPath f14034b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f14035c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LottieValueCallback f14036d;

    public /* synthetic */ s(LottieDrawable lottieDrawable, KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback) {
        this.f14033a = lottieDrawable;
        this.f14034b = keyPath;
        this.f14035c = obj;
        this.f14036d = lottieValueCallback;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f14033a.lambda$addValueCallback$14(this.f14034b, this.f14035c, this.f14036d, lottieComposition);
    }
}
