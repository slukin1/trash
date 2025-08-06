package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class i implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ i f65654a = new i();

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadActiveContexts$9((Cursor) obj);
    }
}
