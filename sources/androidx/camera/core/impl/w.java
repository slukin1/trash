package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f5595b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f5596c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5597d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f5598e;

    public /* synthetic */ w(Executor executor, ListenableFuture listenableFuture, CallbackToFutureAdapter.a aVar, long j11) {
        this.f5595b = executor;
        this.f5596c = listenableFuture;
        this.f5597d = aVar;
        this.f5598e = j11;
    }

    public final void run() {
        this.f5595b.execute(new v(this.f5596c, this.f5597d, this.f5598e));
    }
}
