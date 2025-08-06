package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import q00.a;

public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {
    private final a<BackendRegistry> backendRegistryProvider;
    private final a<EventStore> eventStoreProvider;
    private final a<Executor> executorProvider;
    private final a<SynchronizationGuard> guardProvider;
    private final a<WorkScheduler> workSchedulerProvider;

    public DefaultScheduler_Factory(a<Executor> aVar, a<BackendRegistry> aVar2, a<WorkScheduler> aVar3, a<EventStore> aVar4, a<SynchronizationGuard> aVar5) {
        this.executorProvider = aVar;
        this.backendRegistryProvider = aVar2;
        this.workSchedulerProvider = aVar3;
        this.eventStoreProvider = aVar4;
        this.guardProvider = aVar5;
    }

    public static DefaultScheduler_Factory create(a<Executor> aVar, a<BackendRegistry> aVar2, a<WorkScheduler> aVar3, a<EventStore> aVar4, a<SynchronizationGuard> aVar5) {
        return new DefaultScheduler_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    public DefaultScheduler get() {
        return newInstance(this.executorProvider.get(), this.backendRegistryProvider.get(), this.workSchedulerProvider.get(), this.eventStoreProvider.get(), this.guardProvider.get());
    }
}
