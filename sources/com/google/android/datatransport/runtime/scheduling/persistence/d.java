package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

public final /* synthetic */ class d implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65639a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f65640b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65641c;

    public /* synthetic */ d(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f65639a = sQLiteEventStore;
        this.f65640b = list;
        this.f65641c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f65639a.lambda$loadEvents$14(this.f65640b, this.f65641c, (Cursor) obj);
    }
}
