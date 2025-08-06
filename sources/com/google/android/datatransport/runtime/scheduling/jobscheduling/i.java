package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class i implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f65613a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f65614b;

    public /* synthetic */ i(Uploader uploader, Iterable iterable) {
        this.f65613a = uploader;
        this.f65614b = iterable;
    }

    public final Object execute() {
        return this.f65613a.lambda$logAndUpdateState$5(this.f65614b);
    }
}
