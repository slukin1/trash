package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class h implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f65610a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65611b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65612c;

    public /* synthetic */ h(Uploader uploader, TransportContext transportContext, long j11) {
        this.f65610a = uploader;
        this.f65611b = transportContext;
        this.f65612c = j11;
    }

    public final Object execute() {
        return this.f65610a.lambda$logAndUpdateState$8(this.f65611b, this.f65612c);
    }
}
