package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f21561a;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f21562b;

    private o(Runnable runnable, CountDownLatch countDownLatch) {
        this.f21561a = runnable;
        this.f21562b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new o(runnable, countDownLatch);
    }

    public final void run() {
        Runnable runnable = this.f21561a;
        CountDownLatch countDownLatch = this.f21562b;
        runnable.run();
        countDownLatch.countDown();
    }
}
