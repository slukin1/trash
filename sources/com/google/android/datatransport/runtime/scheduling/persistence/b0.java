package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class b0 implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65632a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65633b;

    public /* synthetic */ b0(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f65632a = sQLiteEventStore;
        this.f65633b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f65632a.lambda$hasPendingEventsFor$6(this.f65633b, (SQLiteDatabase) obj);
    }
}
