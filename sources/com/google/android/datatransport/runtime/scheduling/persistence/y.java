package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class y implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65671a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f65672b;

    public /* synthetic */ y(SQLiteEventStore sQLiteEventStore, long j11) {
        this.f65671a = sQLiteEventStore;
        this.f65672b = j11;
    }

    public final Object apply(Object obj) {
        return this.f65671a.lambda$cleanUp$12(this.f65672b, (SQLiteDatabase) obj);
    }
}
