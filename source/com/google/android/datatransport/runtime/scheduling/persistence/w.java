package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class w implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65669a;

    public /* synthetic */ w(SQLiteEventStore sQLiteEventStore) {
        this.f65669a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f65669a.lambda$recordFailure$3((Cursor) obj);
    }
}
