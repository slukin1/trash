package com.airbnb.lottie;

import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class f implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONObject f14004b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14005c;

    public /* synthetic */ f(JSONObject jSONObject, String str) {
        this.f14004b = jSONObject;
        this.f14005c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonSync(this.f14004b, this.f14005c);
    }
}
