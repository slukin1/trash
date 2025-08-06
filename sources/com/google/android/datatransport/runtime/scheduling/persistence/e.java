package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class e implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f65643a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f65644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f65645c;

    public /* synthetic */ e(SQLiteEventStore sQLiteEventStore, Map map, ClientMetrics.Builder builder) {
        this.f65643a = sQLiteEventStore;
        this.f65644b = map;
        this.f65645c = builder;
    }

    public final Object apply(Object obj) {
        return this.f65643a.lambda$loadClientMetrics$19(this.f65644b, this.f65645c, (Cursor) obj);
    }
}
