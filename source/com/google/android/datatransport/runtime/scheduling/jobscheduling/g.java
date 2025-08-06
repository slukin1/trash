package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class g implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f65607a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65608b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f65609c;

    public /* synthetic */ g(Uploader uploader, TransportContext transportContext, int i11) {
        this.f65607a = uploader;
        this.f65608b = transportContext;
        this.f65609c = i11;
    }

    public final Object execute() {
        return this.f65607a.lambda$upload$0(this.f65608b, this.f65609c);
    }
}
