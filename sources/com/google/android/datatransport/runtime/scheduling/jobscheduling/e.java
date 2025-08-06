package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class e implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f65603a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65604b;

    public /* synthetic */ e(Uploader uploader, TransportContext transportContext) {
        this.f65603a = uploader;
        this.f65604b = transportContext;
    }

    public final Object execute() {
        return this.f65603a.lambda$logAndUpdateState$2(this.f65604b);
    }
}
