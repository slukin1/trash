package androidx.camera.core.impl;

import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f5587b;

    public /* synthetic */ u(ListenableFuture listenableFuture) {
        this.f5587b = listenableFuture;
    }

    public final void run() {
        this.f5587b.cancel(true);
    }
}
