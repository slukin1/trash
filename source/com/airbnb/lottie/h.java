package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f14012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14013c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f14014d;

    public /* synthetic */ h(Context context, String str, String str2) {
        this.f14012b = context;
        this.f14013c = str;
        this.f14014d = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.fromAssetSync(this.f14012b, this.f14013c, this.f14014d);
    }
}
