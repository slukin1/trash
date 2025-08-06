package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import q00.a;

public final class SchemaManager_Factory implements Factory<SchemaManager> {
    private final a<Context> contextProvider;
    private final a<String> dbNameProvider;
    private final a<Integer> schemaVersionProvider;

    public SchemaManager_Factory(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        this.contextProvider = aVar;
        this.dbNameProvider = aVar2;
        this.schemaVersionProvider = aVar3;
    }

    public static SchemaManager_Factory create(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        return new SchemaManager_Factory(aVar, aVar2, aVar3);
    }

    public static SchemaManager newInstance(Context context, String str, int i11) {
        return new SchemaManager(context, str, i11);
    }

    public SchemaManager get() {
        return newInstance(this.contextProvider.get(), this.dbNameProvider.get(), this.schemaVersionProvider.get().intValue());
    }
}
