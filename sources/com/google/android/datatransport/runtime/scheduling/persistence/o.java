package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class o implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ o f65660a = new o();

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$clearDb$13((SQLiteDatabase) obj);
    }
}
