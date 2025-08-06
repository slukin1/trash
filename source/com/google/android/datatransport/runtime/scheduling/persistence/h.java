package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class h implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ h f65653a = new h();

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$readPayload$15((Cursor) obj);
    }
}
