package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class v implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65668a;

    public /* synthetic */ v(SQLiteEventStore sQLiteEventStore) {
        this.f65668a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f65668a.lambda$cleanUp$11((Cursor) obj);
    }
}
