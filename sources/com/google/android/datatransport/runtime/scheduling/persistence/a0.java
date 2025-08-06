package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class a0 implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65627a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65628b;

    public /* synthetic */ a0(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f65627a = sQLiteEventStore;
        this.f65628b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f65627a.lambda$loadBatch$8(this.f65628b, (SQLiteDatabase) obj);
    }
}
