package com.google.firebase.crashlytics.internal.send;

import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f67081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f67082c;

    public /* synthetic */ c(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        this.f67081b = reportQueue;
        this.f67082c = countDownLatch;
    }

    public final void run() {
        this.f67081b.lambda$flushScheduledReportsIfAble$0(this.f67082c);
    }
}
