package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import q00.a;

public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {
    private final a<Context> applicationContextProvider;
    private final a<Clock> monotonicClockProvider;
    private final a<Clock> wallClockProvider;

    public CreationContextFactory_Factory(a<Context> aVar, a<Clock> aVar2, a<Clock> aVar3) {
        this.applicationContextProvider = aVar;
        this.wallClockProvider = aVar2;
        this.monotonicClockProvider = aVar3;
    }

    public static CreationContextFactory_Factory create(a<Context> aVar, a<Clock> aVar2, a<Clock> aVar3) {
        return new CreationContextFactory_Factory(aVar, aVar2, aVar3);
    }

    public static CreationContextFactory newInstance(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    public CreationContextFactory get() {
        return newInstance(this.applicationContextProvider.get(), this.wallClockProvider.get(), this.monotonicClockProvider.get());
    }
}
