package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import q00.a;

public final class TransportRuntime_Factory implements Factory<TransportRuntime> {
    private final a<Clock> eventClockProvider;
    private final a<WorkInitializer> initializerProvider;
    private final a<Scheduler> schedulerProvider;
    private final a<Uploader> uploaderProvider;
    private final a<Clock> uptimeClockProvider;

    public TransportRuntime_Factory(a<Clock> aVar, a<Clock> aVar2, a<Scheduler> aVar3, a<Uploader> aVar4, a<WorkInitializer> aVar5) {
        this.eventClockProvider = aVar;
        this.uptimeClockProvider = aVar2;
        this.schedulerProvider = aVar3;
        this.uploaderProvider = aVar4;
        this.initializerProvider = aVar5;
    }

    public static TransportRuntime_Factory create(a<Clock> aVar, a<Clock> aVar2, a<Scheduler> aVar3, a<Uploader> aVar4, a<WorkInitializer> aVar5) {
        return new TransportRuntime_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    public TransportRuntime get() {
        return newInstance(this.eventClockProvider.get(), this.uptimeClockProvider.get(), this.schedulerProvider.get(), this.uploaderProvider.get(), this.initializerProvider.get());
    }
}
