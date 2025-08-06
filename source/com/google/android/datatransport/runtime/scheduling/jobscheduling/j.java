package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class j implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f65615a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f65616b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65617c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f65618d;

    public /* synthetic */ j(Uploader uploader, Iterable iterable, TransportContext transportContext, long j11) {
        this.f65615a = uploader;
        this.f65616b = iterable;
        this.f65617c = transportContext;
        this.f65618d = j11;
    }

    public final Object execute() {
        return this.f65615a.lambda$logAndUpdateState$4(this.f65616b, this.f65617c, this.f65618d);
    }
}
