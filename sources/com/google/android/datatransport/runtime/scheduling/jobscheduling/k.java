package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Map;

public final /* synthetic */ class k implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f65619a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f65620b;

    public /* synthetic */ k(Uploader uploader, Map map) {
        this.f65619a = uploader;
        this.f65620b = map;
    }

    public final Object execute() {
        return this.f65619a.lambda$logAndUpdateState$7(this.f65620b);
    }
}
