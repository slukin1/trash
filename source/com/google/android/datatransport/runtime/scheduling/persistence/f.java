package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class f implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f65647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LogEventDropped.Reason f65648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65649c;

    public /* synthetic */ f(String str, LogEventDropped.Reason reason, long j11) {
        this.f65647a = str;
        this.f65648b = reason;
        this.f65649c = j11;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordLogEventDropped$18(this.f65647a, this.f65648b, this.f65649c, (SQLiteDatabase) obj);
    }
}
