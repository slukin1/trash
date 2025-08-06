package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f13996b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f13997c;

    public /* synthetic */ d(LottieAnimationView lottieAnimationView, String str) {
        this.f13996b = lottieAnimationView;
        this.f13997c = str;
    }

    public final Object call() {
        return this.f13996b.lambda$fromAssets$2(this.f13997c);
    }
}
