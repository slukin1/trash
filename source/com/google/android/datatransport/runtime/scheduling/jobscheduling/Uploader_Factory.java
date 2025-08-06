package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import q00.a;

public final class Uploader_Factory implements Factory<Uploader> {
    private final a<BackendRegistry> backendRegistryProvider;
    private final a<ClientHealthMetricsStore> clientHealthMetricsStoreProvider;
    private final a<Clock> clockProvider;
    private final a<Context> contextProvider;
    private final a<EventStore> eventStoreProvider;
    private final a<Executor> executorProvider;
    private final a<SynchronizationGuard> guardProvider;
    private final a<Clock> uptimeClockProvider;
    private final a<WorkScheduler> workSchedulerProvider;

    public Uploader_Factory(a<Context> aVar, a<BackendRegistry> aVar2, a<EventStore> aVar3, a<WorkScheduler> aVar4, a<Executor> aVar5, a<SynchronizationGuard> aVar6, a<Clock> aVar7, a<Clock> aVar8, a<ClientHealthMetricsStore> aVar9) {
        this.contextProvider = aVar;
        this.backendRegistryProvider = aVar2;
        this.eventStoreProvider = aVar3;
        this.workSchedulerProvider = aVar4;
        this.executorProvider = aVar5;
        this.guardProvider = aVar6;
        this.clockProvider = aVar7;
        this.uptimeClockProvider = aVar8;
        this.clientHealthMetricsStoreProvider = aVar9;
    }

    public static Uploader_Factory create(a<Context> aVar, a<BackendRegistry> aVar2, a<EventStore> aVar3, a<WorkScheduler> aVar4, a<Executor> aVar5, a<SynchronizationGuard> aVar6, a<Clock> aVar7, a<Clock> aVar8, a<ClientHealthMetricsStore> aVar9) {
        return new Uploader_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    public Uploader get() {
        return newInstance(this.contextProvider.get(), this.backendRegistryProvider.get(), this.eventStoreProvider.get(), this.workSchedulerProvider.get(), this.executorProvider.get(), this.guardProvider.get(), this.clockProvider.get(), this.uptimeClockProvider.get(), this.clientHealthMetricsStoreProvider.get());
    }
}
