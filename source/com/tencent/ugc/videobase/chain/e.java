package com.tencent.ugc.videobase.chain;

import java.util.concurrent.CountDownLatch;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f50839a;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f50840b;

    private e(Runnable runnable, CountDownLatch countDownLatch) {
        this.f50839a = runnable;
        this.f50840b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new e(runnable, countDownLatch);
    }

    public final void run() {
        TXCGPUImageFilter.lambda$runOnDrawAndWaitDone$4(this.f50839a, this.f50840b);
    }
}
