package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class x implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65670a;

    public /* synthetic */ x(SQLiteEventStore sQLiteEventStore) {
        this.f65670a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f65670a.lambda$resetClientMetrics$23((SQLiteDatabase) obj);
    }
}
