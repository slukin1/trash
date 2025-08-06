package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f21531a;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f21532b;

    private c(Runnable runnable, CountDownLatch countDownLatch) {
        this.f21531a = runnable;
        this.f21532b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new c(runnable, countDownLatch);
    }

    public final void run() {
        CustomHandler.lambda$runAndWaitDone$1(this.f21531a, this.f21532b);
    }
}
