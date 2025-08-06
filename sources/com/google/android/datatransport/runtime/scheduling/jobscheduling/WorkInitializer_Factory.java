package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import q00.a;

public final class WorkInitializer_Factory implements Factory<WorkInitializer> {
    private final a<Executor> executorProvider;
    private final a<SynchronizationGuard> guardProvider;
    private final a<WorkScheduler> schedulerProvider;
    private final a<EventStore> storeProvider;

    public WorkInitializer_Factory(a<Executor> aVar, a<EventStore> aVar2, a<WorkScheduler> aVar3, a<SynchronizationGuard> aVar4) {
        this.executorProvider = aVar;
        this.storeProvider = aVar2;
        this.schedulerProvider = aVar3;
        this.guardProvider = aVar4;
    }

    public static WorkInitializer_Factory create(a<Executor> aVar, a<EventStore> aVar2, a<WorkScheduler> aVar3, a<SynchronizationGuard> aVar4) {
        return new WorkInitializer_Factory(aVar, aVar2, aVar3, aVar4);
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    public WorkInitializer get() {
        return newInstance(this.executorProvider.get(), this.storeProvider.get(), this.schedulerProvider.get(), this.guardProvider.get());
    }
}
