package com.airbnb.lottie;

import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class e implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f14000a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f14001b;

    public /* synthetic */ e(String str, AtomicBoolean atomicBoolean) {
        this.f14000a = str;
        this.f14001b = atomicBoolean;
    }

    public final void onResult(Object obj) {
        LottieCompositionFactory.lambda$cache$9(this.f14000a, this.f14001b, (LottieComposition) obj);
    }
}
