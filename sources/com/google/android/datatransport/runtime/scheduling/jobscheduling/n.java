package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class n implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f65623a;

    public /* synthetic */ n(WorkInitializer workInitializer) {
        this.f65623a = workInitializer;
    }

    public final Object execute() {
        return this.f65623a.lambda$ensureContextsScheduled$0();
    }
}
