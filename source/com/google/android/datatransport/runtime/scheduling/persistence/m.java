package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class m implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ m f65658a = new m();

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordLogEventDropped$17((Cursor) obj);
    }
}
