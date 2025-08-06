package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class i implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f14015b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14016c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f14017d;

    public /* synthetic */ i(Context context, String str, String str2) {
        this.f14015b = context;
        this.f14016c = str;
        this.f14017d = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.lambda$fromUrl$0(this.f14015b, this.f14016c, this.f14017d);
    }
}
