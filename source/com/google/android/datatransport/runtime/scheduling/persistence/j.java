package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class j implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ j f65655a = new j();

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$getNextCallTime$5((Cursor) obj);
    }
}
