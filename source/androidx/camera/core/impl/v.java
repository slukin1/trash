package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f5592b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5593c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f5594d;

    public /* synthetic */ v(ListenableFuture listenableFuture, CallbackToFutureAdapter.a aVar, long j11) {
        this.f5592b = listenableFuture;
        this.f5593c = aVar;
        this.f5594d = j11;
    }

    public final void run() {
        DeferrableSurfaces.lambda$surfaceListWithTimeout$0(this.f5592b, this.f5593c, this.f5594d);
    }
}
