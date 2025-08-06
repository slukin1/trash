package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class s implements SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f65664a;

    public /* synthetic */ s(SQLiteDatabase sQLiteDatabase) {
        this.f65664a = sQLiteDatabase;
    }

    public final Object produce() {
        return this.f65664a.beginTransaction();
    }
}
