package com.airbnb.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InputStream f14021b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14022c;

    public /* synthetic */ m(InputStream inputStream, String str) {
        this.f14021b = inputStream;
        this.f14022c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonInputStreamSync(this.f14021b, this.f14022c);
    }
}
