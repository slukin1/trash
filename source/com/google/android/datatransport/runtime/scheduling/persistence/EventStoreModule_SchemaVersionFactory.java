package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final EventStoreModule_SchemaVersionFactory INSTANCE = new EventStoreModule_SchemaVersionFactory();

        private InstanceHolder() {
        }
    }

    public static EventStoreModule_SchemaVersionFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int schemaVersion() {
        return EventStoreModule.schemaVersion();
    }

    public Integer get() {
        return Integer.valueOf(schemaVersion());
    }
}
