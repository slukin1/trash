package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import q00.a;

public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {
    private final a<Clock> clockProvider;
    private final a<EventStoreConfig> configProvider;
    private final a<String> packageNameProvider;
    private final a<SchemaManager> schemaManagerProvider;
    private final a<Clock> wallClockProvider;

    public SQLiteEventStore_Factory(a<Clock> aVar, a<Clock> aVar2, a<EventStoreConfig> aVar3, a<SchemaManager> aVar4, a<String> aVar5) {
        this.wallClockProvider = aVar;
        this.clockProvider = aVar2;
        this.configProvider = aVar3;
        this.schemaManagerProvider = aVar4;
        this.packageNameProvider = aVar5;
    }

    public static SQLiteEventStore_Factory create(a<Clock> aVar, a<Clock> aVar2, a<EventStoreConfig> aVar3, a<SchemaManager> aVar4, a<String> aVar5) {
        return new SQLiteEventStore_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object obj, Object obj2, a<String> aVar) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2, aVar);
    }

    public SQLiteEventStore get() {
        return newInstance(this.wallClockProvider.get(), this.clockProvider.get(), this.configProvider.get(), this.schemaManagerProvider.get(), this.packageNameProvider);
    }
}
