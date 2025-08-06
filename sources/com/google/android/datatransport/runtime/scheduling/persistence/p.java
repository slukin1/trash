package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class p implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ p f65661a = new p();

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadActiveContexts$10((SQLiteDatabase) obj);
    }
}
