package androidx.camera.core.impl.utils;

import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f5588b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f5589c;

    public /* synthetic */ a(Runnable runnable, CountDownLatch countDownLatch) {
        this.f5588b = runnable;
        this.f5589c = countDownLatch;
    }

    public final void run() {
        Threads.lambda$runOnMainSync$0(this.f5588b, this.f5589c);
    }
}
