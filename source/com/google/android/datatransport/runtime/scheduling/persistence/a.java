package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class a implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f65626a;

    public /* synthetic */ a(long j11) {
        this.f65626a = j11;
    }

    public final Object apply(Object obj) {
        return ((Cursor) obj).moveToNext();
    }
}
