package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import q00.a;

public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig> {
    private final a<Clock> clockProvider;

    public SchedulingConfigModule_ConfigFactory(a<Clock> aVar) {
        this.clockProvider = aVar;
    }

    public static SchedulerConfig config(Clock clock) {
        return (SchedulerConfig) Preconditions.checkNotNull(SchedulingConfigModule.config(clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static SchedulingConfigModule_ConfigFactory create(a<Clock> aVar) {
        return new SchedulingConfigModule_ConfigFactory(aVar);
    }

    public SchedulerConfig get() {
        return config(this.clockProvider.get());
    }
}
