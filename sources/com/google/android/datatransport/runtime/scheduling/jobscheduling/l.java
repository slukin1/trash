package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class l implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClientHealthMetricsStore f65621a;

    public /* synthetic */ l(ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f65621a = clientHealthMetricsStore;
    }

    public final Object execute() {
        return this.f65621a.loadClientMetrics();
    }
}
