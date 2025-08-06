package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f14024b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14025c;

    public /* synthetic */ n(String str, String str2) {
        this.f14024b = str;
        this.f14025c = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonStringSync(this.f14024b, this.f14025c);
    }
}
