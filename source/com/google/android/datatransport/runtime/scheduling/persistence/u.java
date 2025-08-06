package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class u implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f65666a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65667b;

    public /* synthetic */ u(long j11, TransportContext transportContext) {
        this.f65666a = j11;
        this.f65667b = transportContext;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordNextCallTime$7(this.f65666a, this.f65667b, (SQLiteDatabase) obj);
    }
}
