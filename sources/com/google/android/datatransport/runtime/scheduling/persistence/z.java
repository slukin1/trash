package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class z implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EventInternal f65674b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65675c;

    public /* synthetic */ z(SQLiteEventStore sQLiteEventStore, EventInternal eventInternal, TransportContext transportContext) {
        this.f65673a = sQLiteEventStore;
        this.f65674b = eventInternal;
        this.f65675c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f65673a.lambda$persist$1(this.f65674b, this.f65675c, (SQLiteDatabase) obj);
    }
}
