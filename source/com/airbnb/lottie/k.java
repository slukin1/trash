package com.airbnb.lottie;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsonReader f14019b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14020c;

    public /* synthetic */ k(JsonReader jsonReader, String str) {
        this.f14019b = jsonReader;
        this.f14020c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonReaderSync(this.f14019b, this.f14020c);
    }
}
