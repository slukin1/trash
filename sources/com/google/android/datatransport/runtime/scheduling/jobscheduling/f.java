package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class f implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f65605a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65606b;

    public /* synthetic */ f(Uploader uploader, TransportContext transportContext) {
        this.f65605a = uploader;
        this.f65606b = transportContext;
    }

    public final Object execute() {
        return this.f65605a.lambda$logAndUpdateState$3(this.f65606b);
    }
}
