package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class c implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f65598a;

    public /* synthetic */ c(Uploader uploader) {
        this.f65598a = uploader;
    }

    public final Object execute() {
        return this.f65598a.lambda$logAndUpdateState$6();
    }
}
