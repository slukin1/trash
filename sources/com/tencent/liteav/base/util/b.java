package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f21529a;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f21530b;

    private b(Runnable runnable, CountDownLatch countDownLatch) {
        this.f21529a = runnable;
        this.f21530b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new b(runnable, countDownLatch);
    }

    public final void run() {
        CustomHandler.lambda$runAndWaitDone$0(this.f21529a, this.f21530b);
    }
}
