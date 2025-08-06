package com.airbnb.lottie;

import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public final /* synthetic */ class p implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ZipInputStream f14030b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14031c;

    public /* synthetic */ p(ZipInputStream zipInputStream, String str) {
        this.f14030b = zipInputStream;
        this.f14031c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromZipStreamSync(this.f14030b, this.f14031c);
    }
}
