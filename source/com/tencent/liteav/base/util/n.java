package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f21559a;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f21560b;

    private n(Runnable runnable, CountDownLatch countDownLatch) {
        this.f21559a = runnable;
        this.f21560b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new n(runnable, countDownLatch);
    }

    public final void run() {
        Runnable runnable = this.f21559a;
        CountDownLatch countDownLatch = this.f21560b;
        runnable.run();
        countDownLatch.countDown();
    }
}
