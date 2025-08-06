package com.airbnb.lottie;

import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class g implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f14009a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f14010b;

    public /* synthetic */ g(String str, AtomicBoolean atomicBoolean) {
        this.f14009a = str;
        this.f14010b = atomicBoolean;
    }

    public final void onResult(Object obj) {
        LottieCompositionFactory.lambda$cache$10(this.f14009a, this.f14010b, (Throwable) obj);
    }
}
