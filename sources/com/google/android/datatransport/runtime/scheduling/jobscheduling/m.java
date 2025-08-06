package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class m implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventStore f65622a;

    public /* synthetic */ m(EventStore eventStore) {
        this.f65622a = eventStore;
    }

    public final Object execute() {
        return Integer.valueOf(this.f65622a.cleanUp());
    }
}
