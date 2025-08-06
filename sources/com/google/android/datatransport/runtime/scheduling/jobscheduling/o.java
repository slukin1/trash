package com.google.android.datatransport.runtime.scheduling.jobscheduling;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f65624b;

    public /* synthetic */ o(WorkInitializer workInitializer) {
        this.f65624b = workInitializer;
    }

    public final void run() {
        this.f65624b.lambda$ensureContextsScheduled$1();
    }
}
