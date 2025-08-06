package com.twitter.sdk.android.core.internal;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionMonitor f51189b;

    public /* synthetic */ c(SessionMonitor sessionMonitor) {
        this.f51189b = sessionMonitor;
    }

    public final void run() {
        this.f51189b.verifyAll();
    }
}
