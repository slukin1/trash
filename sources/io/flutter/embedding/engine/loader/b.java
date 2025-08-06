package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f55148b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f55149c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String[] f55150d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Handler f55151e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Runnable f55152f;

    public /* synthetic */ b(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f55148b = flutterLoader;
        this.f55149c = context;
        this.f55150d = strArr;
        this.f55151e = handler;
        this.f55152f = runnable;
    }

    public final void run() {
        this.f55148b.lambda$ensureInitializationCompleteAsync$0(this.f55149c, this.f55150d, this.f55151e, this.f55152f);
    }
}
