package com.airbnb.lottie;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public final /* synthetic */ class o implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WeakReference f14026b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f14027c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f14028d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f14029e;

    public /* synthetic */ o(WeakReference weakReference, Context context, int i11, String str) {
        this.f14026b = weakReference;
        this.f14027c = context;
        this.f14028d = i11;
        this.f14029e = str;
    }

    public final Object call() {
        return LottieCompositionFactory.lambda$fromRawRes$2(this.f14026b, this.f14027c, this.f14028d, this.f14029e);
    }
}
