package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class b implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65629a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f65630b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f65631c;

    public /* synthetic */ b(SQLiteEventStore sQLiteEventStore, String str, String str2) {
        this.f65629a = sQLiteEventStore;
        this.f65630b = str;
        this.f65631c = str2;
    }

    public final Object apply(Object obj) {
        return this.f65629a.lambda$recordFailure$4(this.f65630b, this.f65631c, (SQLiteDatabase) obj);
    }
}
