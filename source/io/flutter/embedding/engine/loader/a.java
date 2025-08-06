package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f55143b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f55144c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String[] f55145d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Handler f55146e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Runnable f55147f;

    public /* synthetic */ a(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f55143b = flutterLoader;
        this.f55144c = context;
        this.f55145d = strArr;
        this.f55146e = handler;
        this.f55147f = runnable;
    }

    public final void run() {
        this.f55143b.lambda$ensureInitializationCompleteAsync$1(this.f55144c, this.f55145d, this.f55146e, this.f55147f);
    }
}
