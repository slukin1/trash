package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class t implements SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SchemaManager f65665a;

    public /* synthetic */ t(SchemaManager schemaManager) {
        this.f65665a = schemaManager;
    }

    public final Object produce() {
        return this.f65665a.getWritableDatabase();
    }
}
